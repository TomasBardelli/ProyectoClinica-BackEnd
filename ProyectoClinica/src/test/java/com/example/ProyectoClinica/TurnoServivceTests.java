package com.example.ProyectoClinica;

import com.example.ProyectoClinica.exceptions.ResourseNotFoundException;
import com.example.ProyectoClinica.model.Domicilio;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.model.Paciente;
import com.example.ProyectoClinica.model.Turno;
import com.example.ProyectoClinica.service.OdontologoServiceImp;
import com.example.ProyectoClinica.service.PacienteServiceImp;
import com.example.ProyectoClinica.service.TurnoServiceImp;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServivceTests {
    @Autowired
    private PacienteServiceImp pacienteService;
    @Autowired
    private OdontologoServiceImp odontologoService;
    @Autowired
    private TurnoServiceImp turnoService;

    public void cargarDataSet(){
        Domicilio domicilio = new Domicilio("Calle Falsa","123","San Fernando","Buenos Aires");
        Paciente paciente = pacienteService.guardarPaciente(new Paciente("Tomas","Bardelli","tomas@gmail.com","123",new Date(),domicilio));
        this.odontologoService.guardarOdontologo(new Odontologo("Pepe","Perez","123"));
    }
    @Test
    public void altaTurnoTest(){
        this.cargarDataSet();
        turnoService.guardarTurno(new Turno(odontologoService.buscarPorId(1L).get(),pacienteService.buscarPorId(1L).get(),new Date()));
        Assert.assertNotNull(turnoService.buscarPorId(1L));
    }
    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscarPorId(1L));
    }
    @Test
    public void eliminarTurno() throws ResourseNotFoundException {
        turnoService.deleteTurno(1L);
    }
}
