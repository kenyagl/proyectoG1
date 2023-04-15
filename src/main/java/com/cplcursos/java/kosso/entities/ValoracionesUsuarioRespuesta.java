package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ValoracionesPorUsuarioPorRespuesta")
public class ValoracionesUsuarioRespuesta {
   @Id
    private Long idUsuario;
   @Id
    private Long idRespuesta;

   private Boolean puntuacion;
   private String texto;

   private Boolean aviso;

    public ValoracionesUsuarioRespuesta(Long idRespuesta, Boolean puntuacion, String texto, Boolean aviso) {
        this.idRespuesta = idRespuesta;
        this.puntuacion = puntuacion;
        this.texto = texto;
        this.aviso = aviso;
    }
}
