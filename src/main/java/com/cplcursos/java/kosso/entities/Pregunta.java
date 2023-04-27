package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "preguntas")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloPregunta;

    private String textoPregunta;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaPregunta; // Preguntar formato de la fecha

    private Integer votos;
    // Hacer controlador para los votos
    // Como hacer que una persona solo pueda votar una vez o cambiar su voto
    // Solo los usuarios pueden votar

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private List<Etiqueta> etiquetas; // Esto creo que será una lista de etiquetas asignadas a esta pregunta


    private List<Respuesta> respuestas; // Para los comentarios se haría una relación de respuestas a ella misma?

    //Preguntar a Carlos:
    //1) Tenemos que crear una tabla de etiquetas?
    //2) Tenemos que crear una tabla de respuestas? Y las respuestas a las respuestas?
    //3) Votos de las preguntas y de las respestas
    //4) Botones para páginas de preguntasu
}