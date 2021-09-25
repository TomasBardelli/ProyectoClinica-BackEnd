package com.example.ProyectoClinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turnos")
@Getter
@Setter
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turno_sequence")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
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


}
