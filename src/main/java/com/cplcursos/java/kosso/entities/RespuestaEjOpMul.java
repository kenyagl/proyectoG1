package com.cplcursos.java.kosso.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RespuestaEjOpMul {
    @Id
    private idRespuestaEj id;
    //El id es doble y se encuentra en idRespuestaEj: ahí tienes la fecha metida

    //La respuesta es un entero porque el usuario puede elegir entre 4 opciones
    private Integer respuesta;

    //Relación many to one a la tabla EjercicioOpMul

    //Relación many to one a la tabla Usuario
}
