package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ejercicio_op_mul")
public class EjercicioOpMul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dificultad;

    private Integer puntosAcceso;

    private String titulo;

    private String descripcion;

    private String imagen;

    private String opcion1;

    private String opcion2;

    private String opcion3;

    private String opcion4;

    private String respuestaCorrecta;

    private String respuestaUsuario;

    /*@OneToMany(mappedBy = "ejercicioOpMul")
    private List<RespuestaEjOpMul> respuestaEjOpMul = new ArrayList<>();*/
}

