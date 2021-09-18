package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.DTO.PacienteDTO;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<PacienteDTO> buscarTodos();
    Optional<PacienteDTO> buscarPorId(Long id);
    PacienteDTO crearOdontologo(PacienteDTO odontologo);
    PacienteDTO updateOdontologo(PacienteDTO odontologo);
    void deleteOdontologo(Long id);
}
