package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Id
    Long idPregunta;
    @Id
    Long idUsuario;

    private Integer votos;

    private Boolean alerta;

    private String respuesta;

    //@OneToMany(mappedBy = "respuesta")
    //private Comentario comentario;


    public Respuesta(Integer votos, Boolean alerta, String respuesta) {
        this.votos = votos;
        this.alerta = alerta;
        this.respuesta = respuesta;
    }
}