package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RespuestaEjerciciosOpMul")
public class RespuestaEjOpMul {
    @EmbeddedId
    private RespuestaEjId id;

    private Integer respuesta;

    @ManyToOne
    @JoinColumn(name = "id_ejercicioOpMul", nullable = false)
    private EjercicioOpMul ejercicioOpMul;
}
