package com.example.ProyectoClinica.controller;


import com.example.ProyectoClinica.model.Turno;
import com.example.ProyectoClinica.service.interfaces.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    TurnoService turnoService;
    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurnoPorId(@PathVariable Long id){
        turnoService.buscarPorId(id);
        return ResponseEntity.ok(null);
    }
    @GetMapping()
    public ResponseEntity<List<Turno>> buscarTodos(){
       return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Turno> agregarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.guardarTurno(turno));
    }
    @PutMapping()
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarTurno(@PathVariable Long id){
        ResponseEntity<String> response;
        if (turnoService.buscarPorId(id).isPresent()) { // Esta validacion no esta en el enunciado del ejericio, pero se las dejo para que la tengan.
            turnoService.deleteTurno(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
