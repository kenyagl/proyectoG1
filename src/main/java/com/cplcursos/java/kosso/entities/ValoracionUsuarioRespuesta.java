package com.cplcursos.java.kosso.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
   @Id
    private Long idUsuario;
   @Id
    private Long idRespuesta;

   private Boolean puntuacion;
   private String texto;

   private Boolean aviso;
}
