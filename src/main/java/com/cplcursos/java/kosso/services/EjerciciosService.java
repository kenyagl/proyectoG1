package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cplcursos.java.kosso.repositories.EjerciciosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EjerciciosService {
    @Autowired
    private EjerciciosRepository ejerciciosRepository;

    public List<EjercicioOpMul> findAll() {
        return ejerciciosRepository.findAll();
    }

    public Optional<EjercicioOpMul> findById(Long id) {
        return ejerciciosRepository.findById(id);
    }

    public EjercicioOpMul save(EjercicioOpMul ejercicioOpMul) {
        return ejerciciosRepository.save(ejercicioOpMul);
    }

    public void deleteById(Long id) {
        ejerciciosRepository.deleteById(id);
    }
}
