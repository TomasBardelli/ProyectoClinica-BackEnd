package com.example.ProyectoClinica.model.DTO;

import com.example.ProyectoClinica.model.Domicilio;
import com.example.ProyectoClinica.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String apellido;
    private String nombre;
    //private Domicilio domicilio;
    private String email;
    private String dni;
    //private LocalDate fechaIngreso;

    public PacienteDTO (Paciente paciente){
        this.id=paciente.getId();
        this.apellido= paciente.getApellido();
        this.nombre = paciente.getNombre();
        //this.domicilio= paciente.getDomicilio();
        this.email=paciente.getEmail();
        this.dni=paciente.getDni();
        //this.fechaIngreso=paciente.getFechaIngreso();
    }
    public PacienteDTO (){

    }

    private Set<OdontologoDTO> odontologos;
}
