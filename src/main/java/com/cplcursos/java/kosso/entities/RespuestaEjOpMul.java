package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// This entity stores the answers to an exercise

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RespuestaEjerciciosOpMul")
public class RespuestaEjOpMul {

    // @EmbeddedId means that the id is multiple and is defined in class RespuestaEjId
    @EmbeddedId
    private RespuestaEjId id;
    // Is it a numeric value or the String that represents?
    private Integer respuesta;

    // Many answers to a single exercise
    @ManyToOne
    @JoinColumn(name = "ejercicioOpMul_id", nullable = false)
    private EjercicioOpMul ejercicioOpMul;
}
