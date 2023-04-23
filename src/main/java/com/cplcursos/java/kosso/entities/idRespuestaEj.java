package com.cplcursos.java.kosso.entities;

import com.fasterxml.jackson.core.SerializableString;

import java.io.Serializable;
import java.time.LocalDate;

public class idRespuestaEj implements Serializable {

    //quiero que el idUsuario venga de una relación many to one con la tabla Usuario, pero como es otra clase para
    //el doble id no sé cómo hacerlo
    private Long idUsuario;
    private LocalDate fecha;
}
