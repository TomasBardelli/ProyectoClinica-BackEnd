package com.example.ProyectoClinica.service;


import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.DTO.PacienteDTO;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.model.Paciente;
import com.example.ProyectoClinica.repository.PacienteRepository;
import com.example.ProyectoClinica.service.interfaces.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
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
        List<Paciente> pacientes = pacienteRepository.findAll();
        Type listType = new TypeToken<List<PacienteDTO>>(){}.getType();
        List<PacienteDTO> pacientesDTO = modelMapper.map(pacientes,listType);
        return pacientesDTO;
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        Paciente paciente = this.pacienteRepository.getById(id);
        PacienteDTO response = modelMapper.map(paciente,PacienteDTO.class);
        return response;
    }

    @Override
    public String crearOdontologo(Paciente paciente) {
        pacienteRepository.save(paciente);
        return "Se creo paciente con id: "+paciente.getId();
    }

    @Override
    public String updateOdontologo(Paciente paciente) {
        if (pacienteRepository.findById(paciente.getId()).isPresent()){
            pacienteRepository.save(paciente);
            return "Se modifico el paciente con id: "+ paciente.getId();
        }
        else {
            return "No se encontro el paciente con el ID ingresado";
        }
    }

    @Override
    public String deleteOdontologo(Long id) {
        if (pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "Se elimino el paciente con el id: "+ id;
        }else {
            return "No se encontro el paciente con el ID ingresado";
        }
    }
}
