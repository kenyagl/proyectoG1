package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

// This entity stores the answers to an exercise
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RespuestaEjerciciosOpMul")
public class RespuestaEjOpMul {
    @EmbeddedId
    private RespuestaEjId id;
    // @MapsId  used to map a foreign key relationship to the composite key of the target entity
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_usuario")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_ejercios_op_mul")
    private EjercicioOpMul ejercicioOpMul;

    private String respuesta;
    private LocalDateTime fechaRespuesta;
}