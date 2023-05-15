package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.PuntosForo;
import com.cplcursos.java.kosso.repositories.VotosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotosSrvc {
    @Autowired
    private VotosRepo votosRepo;

    public void save(PuntosForo voto){
        votosRepo.save(voto);
    }

    public Integer likesPregunta(Long idPregunta){
        return votosRepo.totalLikesPregunta(idPregunta);
    }
    public Integer dislikesPregunta(Long idPregunta){
        return votosRepo.totalDisLikesPregunta(idPregunta);
    }
    public Integer likesRespuesta(Long idRespuesta){
        return votosRepo.totalLikesPregunta(idRespuesta);
    }
    public Integer dislikesRespuesta(Long idRespuesta){
        return votosRepo.totalDisLikesPregunta(idRespuesta);
    }
    public Integer likesComentario(Long idComentario){
        return votosRepo.totalLikesPregunta(idComentario);
    }
    public Integer dislikesComentario(Long idComentario){
        return votosRepo.totalDisLikesPregunta(idComentario);
    }

}
