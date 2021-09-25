package com.example.ProyectoClinica.controller;

import com.example.ProyectoClinica.model.DTO.PacienteDTO;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.model.Paciente;
import com.example.ProyectoClinica.service.interfaces.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id){
        Paciente paciente = pacienteService.buscarPorId(id).orElse(null);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping()
    public ResponseEntity<List<Paciente>> listPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }
    @PutMapping()
    public ResponseEntity<Paciente> updatearPaciente(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscarPorId(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.updatePaciente(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPaciente (@PathVariable Long id){
        ResponseEntity<String> response = null;

        if (pacienteService.buscarPorId(id).isPresent()) {
            pacienteService.deletePaciente(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
}
