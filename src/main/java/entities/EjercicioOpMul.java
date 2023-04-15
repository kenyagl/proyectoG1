package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ejercicio_op_mul")
public class EjercicioOpMul {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dificultad;

    private Integer puntosAcceso;

    private String titulo;

    private String descripcion;

    private String opcion1;

    private String opcion2;

    private String opcion3;

    private String opcion4;

    private String respuestaCorrecta;

    private String respuestaUsuario;

    public EjercicioOpMul(Integer dificultad, Integer puntosAcceso, String titulo, String descripcion, String opcion1, String opcion2, String opcion3, String opcion4, String respuestaCorrecta, String respuestaUsuario) {
        this.dificultad = dificultad;
        this.puntosAcceso = puntosAcceso;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaUsuario = respuestaUsuario;
    }
}
