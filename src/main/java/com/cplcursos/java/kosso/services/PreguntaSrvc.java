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

    public Integer asignarVotoYObtenerTotal(Long id, Integer valor){
        Optional<Pregunta> preOp = preguntaRepo.findById(id);
        if(preOp.isPresent()){
            Pregunta pregunta = preOp.get();
            Integer acumulados = pregunta.getVotos();
            if (acumulados == null){
                acumulados = 0;
            }
            pregunta.setVotos(valor + acumulados);
            preguntaRepo.save(pregunta);
            return pregunta.getVotos();
        }
        else {
            return null;
        }
    }

    public void borrarPregunta(Long id){
        preguntaRepo.deleteById(id);
    }

    public List<Pregunta> findAll(){
        return preguntaRepo.findAll();
    }

    public Pregunta save(Pregunta pregunta){
        return preguntaRepo.save(pregunta);
    }

    public void setFecha (Pregunta pregunta){
        pregunta.setFechaPregunta(LocalDate.now());
    }

}
