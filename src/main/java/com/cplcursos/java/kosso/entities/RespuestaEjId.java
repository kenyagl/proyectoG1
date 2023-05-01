package com.cplcursos.java.kosso.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class RespuestaEjId implements Serializable {
    private Long idUsuario;
    private Long idEjercicioOpMul;
}