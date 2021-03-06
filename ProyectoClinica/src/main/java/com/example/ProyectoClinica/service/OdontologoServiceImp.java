package com.example.ProyectoClinica.service;

import com.example.ProyectoClinica.exceptions.ResourseNotFoundException;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.repository.OdontologoRepository;
import com.example.ProyectoClinica.service.interfaces.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImp implements OdontologoService {

    private OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoServiceImp(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarPorId(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo updateOdontologo(Odontologo odontologo) {
        return  odontologoRepository.save(odontologo);
    }

    @Override
    public String deleteOdontologo(Long id) throws ResourseNotFoundException {
        if (odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "Se elimino el odontologo con id: "+ id;
        }
        else {
            throw new ResourseNotFoundException("No se encontro el odontologo con el ID ingresado" + id);
        }
    }
}
