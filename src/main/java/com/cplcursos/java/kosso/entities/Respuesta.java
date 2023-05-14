package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer votos = 0;

    private Boolean alerta;

    @Column(length = 500)
    private String textoRespuesta;

    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "respuesta", cascade = CascadeType.ALL)
    private List<Comentario> comentario;

    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "id")
    private Pregunta pregunta;

    // Relacion con votos
    @OneToMany(mappedBy = "respuesta")
    private Set<PuntosForo> puntos;

    public Respuesta(Integer votos, Boolean alerta, String textoRespuesta) {
        this.votos = votos;
        this.alerta = alerta;
        this.textoRespuesta = textoRespuesta;
    }
}