package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.repositories.PreguntaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaSrvc  {
    @Autowired
    private PreguntaRepo preguntaRepo;


    public Optional<Pregunta> findById(Long id) {
        return preguntaRepo.findById(id);
    }

    public void borrarPregunta(Long id){
        preguntaRepo.deleteById(id);
    }

    public List<Pregunta> findAll(){
        return preguntaRepo.findAll();
    }

    public Optional<Pregunta> encontrarPregunta(Long id){
        return preguntaRepo.findById(id);
    }

    public Pregunta save (Pregunta pregunta){
        return preguntaRepo.save(pregunta);
    }

    public void setFecha (Pregunta pregunta){
        pregunta.setFechaPregunta(LocalDate.now());
    }

}
