package com.example.ProyectoClinica.controller;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.service.OdontologoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController("/odontologo")
public class OdontologoController {

    OdontologoServiceImp odontologoService;
    @Autowired
    public OdontologoController(OdontologoServiceImp odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping("/{id}")
    public Optional<OdontologoDTO> buscarOdontologoPorId(@PathVariable Long id){
        return odontologoService.buscarPorId(id);
    }

    @PostMapping("/add")
    public OdontologoDTO agregarOdontologo(@RequestBody OdontologoDTO odontologo){
        return odontologoService.crearOdontologo(odontologo);
    }

    @PutMapping("/update")
    public OdontologoDTO updatearOdontologo(@RequestBody OdontologoDTO odontologo){
        return odontologoService.updateOdontologo(odontologo);
    }

    @DeleteMapping("/{id}")
    public void borrarOdontologo (@PathVariable Long id){
        odontologoService.deleteOdontologo(id);
    }
}
