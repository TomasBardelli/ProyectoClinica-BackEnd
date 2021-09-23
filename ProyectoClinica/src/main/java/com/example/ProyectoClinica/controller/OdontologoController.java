package com.example.ProyectoClinica.controller;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.service.interfaces.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologoPorId(@PathVariable Long id){
        return odontologoService.buscarPorId(id);
    }

    @GetMapping()
    public List<OdontologoDTO> listOdontologos(){
        return odontologoService.buscarTodos();
    }

    @PostMapping("/registrar")
    public ResponseEntity<OdontologoDTO> agregarOdontologo(@RequestBody OdontologoDTO odontologo){
        odontologoService.guardarOdontologo(odontologo);
        return ResponseEntity.ok(null);
    }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> updatearOdontologo(@RequestBody OdontologoDTO odontologo){
        odontologoService.updateOdontologo(odontologo);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> borrarOdontologo (@PathVariable Long id){
        odontologoService.deleteOdontologo(id);
        return ResponseEntity.ok(null);
    }


}
