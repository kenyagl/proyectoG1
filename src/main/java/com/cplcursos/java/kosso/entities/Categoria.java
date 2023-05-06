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
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriaEjercicios", nullable = false)
    private Integer id;
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @ManyToMany (mappedBy = "categorias")
    private List<EjercicioOpMul> ejercicios;

    @ManyToMany
    @JoinTable(
            name = "categoria_pregunta",
            joinColumns = @JoinColumn(name = "idPregunta"),
            inverseJoinColumns = @JoinColumn(name = "idCategoria"))
    private List<Pregunta> preguntas;


}
