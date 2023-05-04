package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.entities.Respuesta;
import com.cplcursos.java.kosso.repositories.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaSrvc {

    @Autowired
    private RespuestaRepo respuestaRepo;

    public Optional<Respuesta> findById(Long id){
        return respuestaRepo.findById(id);
    }
    public List<Respuesta> findAll(){
        return respuestaRepo.findAll();
    }
    public Respuesta save (Respuesta respuesta){
        return respuestaRepo.save(respuesta);
    }
    public void borrarRespuesta(Long id){
        respuestaRepo.deleteById(id);
    }
    public void setFecha(Respuesta respuesta){
        respuesta.setFechaRespuesta(LocalDate.now());
    }




}
