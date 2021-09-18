package com.example.ProyectoClinica.service;


import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.DTO.PacienteDTO;
import com.example.ProyectoClinica.repository.PacienteRepository;
import com.example.ProyectoClinica.service.interfaces.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImp implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PacienteDTO> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<PacienteDTO> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public PacienteDTO crearOdontologo(PacienteDTO paciente) {
        if (paciente != null){
            return pacienteRepository.save(paciente);
        }
        return new PacienteDTO();
    }

    @Override
    public PacienteDTO updateOdontologo(PacienteDTO paciente) {
        if (paciente != null){
            return pacienteRepository.save(paciente);
        }
        return new PacienteDTO();
    }

    @Override
    public void deleteOdontologo(Long id) {
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
        }
    }
}
