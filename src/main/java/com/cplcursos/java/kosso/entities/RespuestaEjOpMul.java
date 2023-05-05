package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

// This entity stores the answers to an exercise
// This entity stores only correct answers
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RespuestaEjerciciosOpMul")
public class RespuestaEjOpMul {
    @EmbeddedId
    private RespuestaEjId id;

    private String respuesta;
    private LocalDateTime fechaRespuesta;
/*    Los datos que requieren las estadísticas son los siguientes:
    -Número de ejercicios contestados EjercicioOpMul (intentos)
    -Puntos ejercicios y puntos respuestas Usuario (Desempeño)
    -Preguntas correctas RespuestaEjOpMul*/
}