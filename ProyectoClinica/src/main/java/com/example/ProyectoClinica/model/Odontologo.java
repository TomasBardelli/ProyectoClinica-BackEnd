package com.example.ProyectoClinica.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "odontologos")
@Getter
@Setter
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "odontologo_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    private List<Turno> turnos = new ArrayList<>();

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Odontologo(Long id, String apellido, String nombre, String matricula) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }
    public Odontologo() {

    }
}
