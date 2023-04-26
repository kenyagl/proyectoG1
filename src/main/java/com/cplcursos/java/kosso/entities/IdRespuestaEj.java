package com.cplcursos.java.kosso.entities;

import lombok.AllArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
public class IdRespuestaEj implements Serializable {

    //quiero que el idUsuario venga de una relación many to one con la tabla Usuario, pero como es otra clase para
    //el doble id no sé cómo hacerlo
    private Long idUsuario;
    private Long idEjercicioOpMul;
}
