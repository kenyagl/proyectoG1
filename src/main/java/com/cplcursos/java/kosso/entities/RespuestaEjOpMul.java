package com.cplcursos.java.kosso.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RespuestaEjOpMul {
    @Id
    private IdRespuestaEj idRespuestaEj;
    //El id es doble y se encuentra en idRespuestaEj: ahí tienes la fecha metida

    private String respuesta;

    private LocalDateTime fechaRespuesta;

}
