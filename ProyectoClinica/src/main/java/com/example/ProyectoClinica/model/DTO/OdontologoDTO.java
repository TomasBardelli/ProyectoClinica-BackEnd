package com.example.ProyectoClinica.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    private Set<PacienteDTO> pacientes;
}
