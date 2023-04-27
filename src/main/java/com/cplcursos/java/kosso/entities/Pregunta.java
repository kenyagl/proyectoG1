package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloPregunta;

    private String textoPregunta;

    private String fechaPregunta;

    private Long idUsuarioPregunta;

//    private Long idEtiquetas;

    private Long idRespuestas;
    @ManyToMany
    @JoinTable(
            name = "pregunta_etiqueta",
            joinColumns = @JoinColumn(name = "pregunta_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id", referencedColumnName = "id")
    )
    private List<Etiqueta> etiquetas = new ArrayList<>();

    //Preguntar a Carlos:
    //1) Tenemos que crear una tabla de etiquetas?
    //2) Tenemos que crear una tabla de respuestas? Y las respuestas a las respuestas?
}