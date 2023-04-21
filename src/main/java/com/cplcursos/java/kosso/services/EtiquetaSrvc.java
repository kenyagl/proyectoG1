package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Etiqueta;
import com.cplcursos.java.kosso.repositories.EtiquetaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaSrvc {
    @Autowired
    private EtiquetaRepo etiquetaRepo;

    public List<Etiqueta> findAll() {
        return etiquetaRepo.findAll();
    }

    public Optional<Etiqueta> findById(Long id) {
        return etiquetaRepo.findById(id);
    }

    public Etiqueta save(Etiqueta etiqueta) {
        return etiquetaRepo.save(etiqueta);
    }

    public void deleteById(Long id) {
        etiquetaRepo.deleteById(id);
    }
}
