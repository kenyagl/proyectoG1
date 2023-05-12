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

    private Integer puntos;

    @ManyToOne
    private Usuario usuario; // el usuario que vota

    private Long idContenido; // pregunta, respuesta o comentario o votos

    private String tipoContenido;

    private LocalDate fechaVoto;

}
