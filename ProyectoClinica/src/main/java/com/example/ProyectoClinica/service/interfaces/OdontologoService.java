package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.exceptions.ResourseNotFoundException;
import com.example.ProyectoClinica.model.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    List<Odontologo> buscarTodos();
    Optional<Odontologo> buscarPorId(Long id);
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo updateOdontologo(Odontologo odontologo);
    String deleteOdontologo(Long id) throws ResourseNotFoundException;
}
