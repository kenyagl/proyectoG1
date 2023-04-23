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
    private IdRespuestaEj idRespuestaEj;
    //El id es doble y se encuentra en idRespuestaEj: ahí tienes la fecha metida
    @EmbeddedId
    private RespuestaEjId id;

    private String respuesta;
    private Integer respuesta;

    private LocalDateTime fechaRespuesta;
    @ManyToOne
    @JoinColumn(name = "id_ejercicioOpMul", nullable = false)
    private EjercicioOpMul ejercicioOpMul;
}
