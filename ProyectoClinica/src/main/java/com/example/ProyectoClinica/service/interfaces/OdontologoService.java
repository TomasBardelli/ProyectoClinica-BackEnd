package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    List<OdontologoDTO> buscarTodos();
    Optional<OdontologoDTO> buscarPorId(Long id);
    OdontologoDTO crearOdontologo(OdontologoDTO odontologo);
    OdontologoDTO updateOdontologo(OdontologoDTO odontologo);
    void deleteOdontologo(Long id);
}
