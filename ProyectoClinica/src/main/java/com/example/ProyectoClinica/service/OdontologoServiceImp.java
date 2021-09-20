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
        Optional<Odontologo> found = odontologoRepository.findById(id);
        return objectMapper.convertValue(found, OdontologoDTO.class);
    }

    @Override
    public String guardarOdontologo(OdontologoDTO odontologo) {
        Odontologo odontologo1 = objectMapper.convertValue(odontologo, Odontologo.class);
        odontologoRepository.save(odontologo1);
        return "Se creo odontologo con id: "+ odontologo.getId();
    }

    @Override
    public String updateOdontologo(OdontologoDTO odontologo) {
        if (odontologoRepository.findById(odontologo.getId()).isPresent()){
            Odontologo odontologo1 = objectMapper.convertValue(odontologo, Odontologo.class);
            odontologoRepository.save(odontologo1);
            return "Se modifico el odontologo con id: "+ odontologo1.getId();
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
