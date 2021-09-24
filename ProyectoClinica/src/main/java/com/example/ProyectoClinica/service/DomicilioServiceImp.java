package com.example.ProyectoClinica.service;

import com.example.ProyectoClinica.model.Domicilio;
import com.example.ProyectoClinica.repository.DomicilioRepository;
import com.example.ProyectoClinica.service.interfaces.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DomicilioServiceImp implements DomicilioService {

    private DomicilioRepository domicilioRepository;
    @Autowired
    public DomicilioServiceImp(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Optional<Domicilio> buscarPorId(Long id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }
}
