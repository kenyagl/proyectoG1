package com.cplcursos.java.kosso.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RespuestaEjercicioOpMul {

    @Id
    private Long id;

    private Integer respuesta;

    //Relación many to one a la tabla EjercicioOpMul
}
