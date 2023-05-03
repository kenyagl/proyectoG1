package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String nombre;
    private String clave;
    private String rol;
    private String foto;
    private Boolean activo = false;
    private Date creadoEl;
    private String acercaDe;
    // Linked to tuprogreso must have some type of relationship to date in class RespuestaEjOpMul
    private Integer puntosEjercicios;
    // Linked to tuprogreso must have some type of relationship to date in class RespuestaEjOpMul
    private Integer puntosRespuestas;
    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, Integer puntosEjercicios, Integer puntosRespuestas) {
        this.id = id;
        this.puntosEjercicios = puntosEjercicios;
        this.puntosRespuestas = puntosRespuestas;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<DiaCalendario> diaCalendario = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Pregunta> preguntas;

    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany
    @JoinColumn(name = "usuario_id")
    private List<RespuestaEjOpMul> respuestasEjOpMul = new ArrayList<>();
}
