package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.DTO.PacienteDTO;
import com.example.ProyectoClinica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<PacienteDTO> buscarTodos();
    PacienteDTO buscarPorId(Long id);
    String crearOdontologo(Paciente paciente);
    String updateOdontologo(Paciente paciente);
    String deleteOdontologo(Long id);
}
