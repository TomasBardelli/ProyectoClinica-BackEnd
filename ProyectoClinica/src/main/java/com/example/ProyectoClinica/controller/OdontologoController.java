package com.example.ProyectoClinica.controller;

import com.example.ProyectoClinica.exceptions.ResourseNotFoundException;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.service.interfaces.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoPorId(@PathVariable Long id){
        Odontologo odontologo = odontologoService.buscarPorId(id).orElse(null);

        return ResponseEntity.ok(odontologo);
    }

    @GetMapping()
    public ResponseEntity<List<Odontologo>> listOdontologos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.buscarPorId(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.updateOdontologo(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarOdontologo (@PathVariable Long id) throws ResourseNotFoundException {
        odontologoService.deleteOdontologo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }


}
