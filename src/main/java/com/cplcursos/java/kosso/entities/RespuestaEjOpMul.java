package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private RespuestaEjId idRespuestaEjemplo;
    private String respuesta;
    private LocalDateTime fechaRespuesta;
}
