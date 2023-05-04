package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Comentario;
import com.cplcursos.java.kosso.repositories.ComentarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioSrvc {

    @Autowired
    private ComentarioRepo comentarioRepo;

    public Optional<Comentario> findById(Long id){
        return comentarioRepo.findById(id);
    }

    public List<Comentario> findAll(){
        return comentarioRepo.findAll();
    }

    public Comentario save (Comentario comentario){
        return comentarioRepo.save(comentario);
    }

    public void borrarRespuesta(Long id){
        comentarioRepo.deleteById(id);
    }

    public void setFecha (Comentario comentario){
        comentario.setFechaComentario(LocalDate.now());
    }




}
