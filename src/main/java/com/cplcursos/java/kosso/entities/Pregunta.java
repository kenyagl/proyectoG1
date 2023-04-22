package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaPregunta; // Preguntar formato de la fecha

    private Long idUsuarioPregunta;

    private Long idEtiquetas;

    private Long idRespuestas;

    //Preguntar a Carlos:
    //1) Tenemos que crear una tabla de etiquetas?
    //2) Tenemos que crear una tabla de respuestas? Y las respuestas a las respuestas?
    //3) Votos de las preguntas y de las respuestas
    //4) Botones para páginas de preguntas
}