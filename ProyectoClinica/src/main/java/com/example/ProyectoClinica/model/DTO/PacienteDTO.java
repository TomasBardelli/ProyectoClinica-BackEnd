package com.example.ProyectoClinica.model.DTO;

import com.example.ProyectoClinica.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;

    private Set<OdontologoDTO> odontologos;
}
