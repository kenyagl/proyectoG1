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

   /* //Servicios para imágenes
    private final Path root = Paths.get("./uploads");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }*/

}
