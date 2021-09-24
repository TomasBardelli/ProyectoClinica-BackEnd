package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.model.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {
    List<Domicilio> buscarTodos();
    Domicilio guardar(Domicilio domicilio);
    Optional<Domicilio>buscarPorId(Long id);
    void eliminar(Long id);
}
