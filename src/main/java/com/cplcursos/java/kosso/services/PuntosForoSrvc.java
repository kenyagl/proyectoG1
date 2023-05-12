package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.entities.PuntosForo;
import com.cplcursos.java.kosso.repositories.PuntosForoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PuntosForoSrvc {

    @Autowired
    private PuntosForoRepo puntosForoRepo;


    public void puntuarContenido(Long idContenido, Integer puntos, String tipoContenido, Usuario usuario){
        PuntosForo puntosForo = new PuntosForo();
        puntosForo.setUsuario(usuario);
        puntosForo.setFechaVoto(LocalDate.now());
        puntosForo.setPuntos(puntos);
        puntosForo.setTipoContenido(tipoContenido);
        puntosForo.setIdContenido(idContenido);
        puntosForoRepo.save(puntosForo);
    }

    public Long countByIdAndTipoContenido(Long idContenido, String tipoContenido){
        return puntosForoRepo.countByIdAndTipoContenido(idContenido, tipoContenido);
    }


}
