package com.example.ProyectoClinica.service;

import com.example.ProyectoClinica.model.Turno;
import com.example.ProyectoClinica.repository.TurnoRepository;
import com.example.ProyectoClinica.service.interfaces.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoServiceImp implements TurnoService {

    private TurnoRepository turnoRepository;
    @Autowired
    public TurnoServiceImp(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> buscarPorId(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno guardarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno updateTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
