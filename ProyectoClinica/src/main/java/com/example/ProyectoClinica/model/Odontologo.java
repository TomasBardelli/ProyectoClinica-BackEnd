package com.example.ProyectoClinica.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "odontologo_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Paciente> pacientes;

}