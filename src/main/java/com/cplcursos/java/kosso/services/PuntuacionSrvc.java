package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Puntuacion;
import com.cplcursos.java.kosso.repositories.PuntuacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntuacionSrvc {
    @Autowired
    private PuntuacionRepo puntuacionRepo;

    public List<Puntuacion> findAll() {
        return puntuacionRepo.findAll();
    }

    public Optional<Puntuacion> findById(Long id) {
        return puntuacionRepo.findById(id);
    }

    public Puntuacion save(Puntuacion puntuacion) {
        return puntuacionRepo.save(puntuacion);
    }

    public void deleteById(Long id) {
        puntuacionRepo.deleteById(id);
    }
}
