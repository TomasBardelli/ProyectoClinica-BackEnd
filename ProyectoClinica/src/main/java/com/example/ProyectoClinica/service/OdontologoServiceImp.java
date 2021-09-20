package com.example.ProyectoClinica.service;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.repository.OdontologoRepository;
import com.example.ProyectoClinica.service.interfaces.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImp implements OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Type listType = new TypeToken<List<OdontologoDTO>>(){}.getType();
        List<OdontologoDTO> odontologosDTO = modelMapper.map(odontologos,listType);
        return odontologosDTO;
    }

    @Override
    public OdontologoDTO buscarPorId(Long id) {
        Odontologo odontologo = this.odontologoRepository.getById(id);
        OdontologoDTO response = modelMapper.map(odontologo,OdontologoDTO.class);
        return response;
    }

    @Override
    public String crearOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
        return "Se creo odontologo con id: "+ odontologo.getId();
    }

    @Override
    public String updateOdontologo(Odontologo odontologo) {
        if (odontologoRepository.findById(odontologo.getId()).isPresent()){
            odontologoRepository.save(odontologo);
            return "Se modifico el odontologo con id: "+ odontologo.getId();
        }
        else {
            return "No se encontro el odontologo con el ID ingresado";
        }
    }

    @Override
    public String deleteOdontologo(Long id) {
        if (odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "Se elimino el odontologo con id: "+ id;
        }
        else {
            return "No se encontro el odontologo con el ID ingresado";
        }
    }
}
