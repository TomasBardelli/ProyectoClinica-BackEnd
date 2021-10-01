package com.example.ProyectoClinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turno_sequence")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne()
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
