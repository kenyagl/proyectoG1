package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "puntosForo")
public class PuntosForo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

        //El usuario no hace falta porque es una propiedad de la entidad votada

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario; // el usuario que vota

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPregunta")
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idRespuesta")
    private Respuesta respuesta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idComentario")
    private Comentario comentario;

    private Integer puntos;

    private LocalDate fechaVoto;
}
