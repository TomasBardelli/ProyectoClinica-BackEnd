package com.example.ProyectoClinica.service;

import com.example.ProyectoClinica.model.DTO.OdontologoDTO;
import com.example.ProyectoClinica.repository.OdontologoRepository;
import com.example.ProyectoClinica.service.interfaces.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<OdontologoDTO> buscarPorId(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public OdontologoDTO crearOdontologo(OdontologoDTO odontologo) {
        if (odontologo != null){
            return odontologoRepository.save(odontologo);
        }
        return new OdontologoDTO();
    }

    @Override
    public OdontologoDTO updateOdontologo(OdontologoDTO odontologo) {
        if (odontologo != null){
            return odontologoRepository.save(odontologo);
        }
        return new OdontologoDTO();
    }

    @Override
    public void deleteOdontologo(Long id) {
        if (odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
        }
    }
}
