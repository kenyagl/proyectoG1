package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(length = 64)
    private String imagen;

    private String opcion1;

    private String opcion2;

    private String opcion3;

    private String opcion4;

    private String respuestaCorrecta;

    private String respuestaUsuario;

    @Transient
    public String getImagenPath() {
        if (imagen == null || id == null) {
            return null;
        }

        return "/image/ejercicio-photos/" + id + "/" + imagen;
    }

    @ManyToMany
    @JoinTable(
            name = "ejercicio_categoria",
            joinColumns = @JoinColumn(name = "id_ejercicioOpMul"),
            inverseJoinColumns = @JoinColumn(name = "id_categoriaEjercicios")
    )
    private List<CategoriaEjercicios> categorias;

}

