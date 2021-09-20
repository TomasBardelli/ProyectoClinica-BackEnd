package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    List<OdontologoDTO> buscarTodos();
    OdontologoDTO buscarPorId(Long id);
    String guardarOdontologo(OdontologoDTO odontologo);
    String updateOdontologo(OdontologoDTO odontologo);
    String deleteOdontologo(Long id);
}
