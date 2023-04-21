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
public class ValoracionUsuarioRespuesta {

    @EmbeddedId
    private idValoracion id;

   private Boolean puntuacion;

   private String texto;

   private Boolean aviso;
}
