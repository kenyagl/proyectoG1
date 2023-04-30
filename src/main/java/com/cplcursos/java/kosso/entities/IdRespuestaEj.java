package com.cplcursos.java.kosso.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class IdRespuestaEj implements Serializable {

    //quiero que el idUsuario venga de una relación many to one con la tabla Usuario, pero como es otra clase para
    //el doble id no sé cómo hacerlo

    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private EjercicioOpMul ejercicio;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
