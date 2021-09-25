package com.example.ProyectoClinica.service;


import com.example.ProyectoClinica.exceptions.ResourseNotFoundException;
import com.example.ProyectoClinica.model.DTO.PacienteDTO;
import com.example.ProyectoClinica.model.Paciente;
import com.example.ProyectoClinica.repository.PacienteRepository;
import com.example.ProyectoClinica.service.interfaces.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImp implements PacienteService {

    private PacienteRepository pacienteRepository;
    @Autowired
    public PacienteServiceImp(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        if(paciente.getFechaIngreso()==null){
            paciente.setFechaIngreso(new Date());
        }
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public String deletePaciente(Long id) throws ResourseNotFoundException {
        if (pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "Se elimino el paciente con el id: "+ id;
        }else {
            throw new ResourseNotFoundException("No se encontro el odontologo con el ID ingresado" + id);
        }
    }
}

