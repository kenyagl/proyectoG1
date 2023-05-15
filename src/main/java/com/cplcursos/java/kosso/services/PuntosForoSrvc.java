package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.*;
import com.cplcursos.java.kosso.repositories.PuntosForoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PuntosForoSrvc {


    @Autowired
    private PuntosForoRepo puntosForoRepo;


    public void puntuarPregunta(Pregunta pregunta){
        PuntosForo puntosForo = new PuntosForo();
        puntosForo.setPregunta(pregunta);
        puntosForo.setFechaVoto(LocalDate.now());
        puntosForo.setPuntos(10);
        puntosForoRepo.save(puntosForo);
    }
    public void puntuarRespuesta(Respuesta respuesta){
        PuntosForo puntosForo = new PuntosForo();
        puntosForo.setRespuesta(respuesta);
        puntosForo.setFechaVoto(LocalDate.now());
        puntosForo.setPuntos(10);
        puntosForoRepo.save(puntosForo);
    }
    public void puntuarComentario(Comentario comentario){
        PuntosForo puntosForo = new PuntosForo();
        puntosForo.setComentario(comentario);
        puntosForo.setFechaVoto(LocalDate.now());
        puntosForo.setPuntos(5);
        puntosForoRepo.save(puntosForo);
    }

}
