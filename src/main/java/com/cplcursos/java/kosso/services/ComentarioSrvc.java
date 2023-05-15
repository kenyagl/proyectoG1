package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Comentario;
import com.cplcursos.java.kosso.entities.Pregunta;
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

    public Integer asignarVotoYObtenerTotal(Long id, Integer valor){
        Optional<Comentario> ComentarioOp = comentarioRepo.findById(id);
        /*
        if(ComentarioOp.isPresent()){
            Comentario comentario = ComentarioOp.get();
            Integer acumulados = comentario.getVotos();
            if (acumulados == null){
                acumulados = 0;
            }
            comentario.setVotos(valor + acumulados);
            comentarioRepo.save(comentario);
            return comentario.getVotos();
        }
        else {
            return null;
        }

         */
        return null;
    }


}
