package com.example.ProyectoClinica.repository;

import com.example.ProyectoClinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
