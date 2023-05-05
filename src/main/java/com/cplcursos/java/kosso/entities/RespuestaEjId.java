package com.cplcursos.java.kosso.entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class RespuestaEjId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejercicio_id")
    private EjercicioOpMul ejercicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}