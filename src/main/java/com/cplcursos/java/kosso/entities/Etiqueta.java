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
@Table(name="Etiquetas")
public class Etiqueta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nombre;

    @ManyToMany(mappedBy = "etiquetas")
    private List<Pregunta> preguntas = new ArrayList<>();

}


