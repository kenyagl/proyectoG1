package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoriaEjercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriaEjercicios", nullable = false)
    private Integer id_CategoriaEjercicios;
    private String nombre;

    public CategoriaEjercicios(String nombre) {
        this.nombre = nombre;
    }

    @ManyToMany
    @JoinTable(
            name = "ejercicio_categoria",
            joinColumns = @JoinColumn(name = "id_categoriaEjercicios"),
            inverseJoinColumns = @JoinColumn(name = "id_ejercicioOpMul")
    )
    private List<EjercicioOpMul> ejercicios;
}
