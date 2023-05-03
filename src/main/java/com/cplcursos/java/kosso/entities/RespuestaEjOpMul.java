package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

// This entity stores the answers to an exercise
// This entity must contain a boolean to store if the answer was correct or incorrect ->
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RespuestaEjerciciosOpMul")
public class RespuestaEjOpMul {
    @EmbeddedId
    private RespuestaEjId id;
    // @MapsId  used to map a foreign key relationship to the composite key of the target entity
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_usuario")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_ejercios_op_mul")
    private EjercicioOpMul ejercicioOpMul;
    private Boolean esCorrecta;
    private String respuesta;
    private LocalDateTime fechaRespuesta;
/*    Los datos que requieren las estadísticas son los siguientes:
    -Número de ejercicios contestados EjercicioOpMul (intentos)
    -Puntos ejercicios y puntos respuestas Usuario (Desempeño)
    -Preguntas correctas RespuestaEjOpMul*/
}