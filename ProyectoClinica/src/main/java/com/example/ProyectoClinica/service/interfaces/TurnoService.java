package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.exceptions.ResourseNotFoundException;
import com.example.ProyectoClinica.model.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {
    List<Turno> buscarTodos();
    Optional<Turno> buscarPorId(Long id);
    Turno guardarTurno(Turno turno);
    Turno updateTurno(Turno turno);
    void deleteTurno(Long id) throws ResourseNotFoundException;
}
