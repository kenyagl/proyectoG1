package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cplcursos.java.kosso.repositories.EjercicioRepo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class EjerciciosSrvc {
    @Autowired
    private EjercicioRepo ejerciciosRepository;

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


    //Método para encontrar el siguiente ejercicio
    public Long findIdNextEjercicio(Long id) {
        Long nextId = id + 1;
        Optional<EjercicioOpMul> nextEj = ejerciciosRepository.findById(nextId);

        while(!nextEj.isPresent() && nextId > 0 && nextId < (id+10)) {
            nextId++;
            nextEj = ejerciciosRepository.findById(nextId);
        }

        if(nextEj.isPresent()){
            return nextEj.get().getId();
        }

        return null;
    }

    public List<EjercicioOpMul> encontrarEjerPorCategoria(String keyword) {
        if(keyword == null || keyword.isEmpty()){
            return ejerciciosRepository.findAll();
        }

        return ejerciciosRepository.encontrarEjerPorCategoria(keyword);
    }

}
