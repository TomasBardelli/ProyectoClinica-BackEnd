package com.example.ProyectoClinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turno_sequence")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private Date date;

    public Turno(){

    }

    public Turno(Odontologo odontologo, Paciente paciente, Date date) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.date = date;
    }

    public Turno(Long id, Odontologo odontologo, Paciente paciente, Date date) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.date = date;
    }
}
