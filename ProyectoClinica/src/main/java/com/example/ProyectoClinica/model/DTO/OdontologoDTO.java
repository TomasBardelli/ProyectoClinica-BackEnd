package com.example.ProyectoClinica.model.DTO;

import com.example.ProyectoClinica.model.Odontologo;
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

    public OdontologoDTO(Odontologo odontologo){
        this.id= odontologo.getId();
        this.apellido= odontologo.getApellido();
        this.nombre = odontologo.getNombre();
        this.matricula= odontologo.getMatricula();
    }
    public OdontologoDTO(){

    }

    private Set<PacienteDTO> pacientes;
}
