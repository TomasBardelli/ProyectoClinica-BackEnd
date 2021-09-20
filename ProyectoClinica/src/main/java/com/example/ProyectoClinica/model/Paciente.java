package com.example.ProyectoClinica.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paciente_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    //private Domicilio domicilio;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;


    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

}
