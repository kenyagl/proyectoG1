package com.cplcursos.java.kosso.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class idValoracion implements Serializable {

    private Long idUsuario;
    private Long idRespuesta;
}
