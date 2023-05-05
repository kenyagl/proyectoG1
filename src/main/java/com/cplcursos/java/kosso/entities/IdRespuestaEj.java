package com.cplcursos.java.kosso.entities;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class IdRespuestaEj implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ejercicio_id", referencedColumnName = "id")
    private EjercicioOpMul ejercicioOpMul;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
