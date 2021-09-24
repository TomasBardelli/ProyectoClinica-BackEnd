package com.example.ProyectoClinica.controller;

import com.example.ProyectoClinica.model.DTO.PacienteDTO;
import com.example.ProyectoClinica.model.Paciente;
import com.example.ProyectoClinica.service.interfaces.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Paciente> buscarPacientePorId(@PathVariable Long id){
        return pacienteService.buscarPorId(id);
    }

    @GetMapping()
    public List<Paciente> listPacientes(){
        return pacienteService.buscarTodos();
    }

    @PostMapping("/registrar")
    public ResponseEntity<Paciente> agregarPaciente(@RequestBody Paciente paciente){
        pacienteService.guardarPaciente(paciente);
        return ResponseEntity.ok(null);
    }
    @PutMapping()
    public ResponseEntity<Paciente> updatearPaciente(@RequestBody Paciente paciente){
        pacienteService.guardarPaciente(paciente);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteDTO> borrarPaciente (@PathVariable Long id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok(null);
    }
}
