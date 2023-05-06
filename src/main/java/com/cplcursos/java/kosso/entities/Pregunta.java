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

    private String foto;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaPregunta; // Preguntar formato de la fecha

    private Integer votos;
    // Como hacer que una persona solo pueda votar una vez o cambiar su voto
    // Solo los usuarios pueden votar

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToMany
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "pregunta",cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;



    //Preguntar a Carlos:
    //4) Botones para páginas de preguntas

    // agregar en el controlador de votos un set de puntos al usuario por los votos

    // TODO y asignarle su usuario(thymeleaf)

    @Transient
    public String getFotoPath() {
        if (foto == null || id == null) {
            return null;
        }

        return "/image/pregunta-photos/" + id + "/" + foto;
    }

}