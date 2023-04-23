package com.cplcursos.java.kosso.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class RespuestaEjId implements Serializable {
    // TODO create Many-to-one relationship with Usuario table and create an embedabble id
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "fecha_id")
    private LocalDate fecha;
}
