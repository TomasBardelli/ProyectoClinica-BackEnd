package com.example.ProyectoClinica.service.interfaces;

import com.example.ProyectoClinica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> buscarTodos();
    Optional<Paciente> buscarPorId(Long id);
    Paciente guardarPaciente(Paciente paciente);
    Paciente updatePaciente(Paciente paciente);
    String deletePaciente(Long id);
}
