package com.cplcursos.java.kosso.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

// This entity stores the answers to an exercise
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RespuestaEjerciciosOpMul")
public class RespuestaEjOpMul {
    // TODO Preguntar a Carlos porque se crean dos relaciones extras en la BBDD
    @EmbeddedId
    private IdRespuestaEj id;
    private String respuesta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime fechaRespuesta;
}