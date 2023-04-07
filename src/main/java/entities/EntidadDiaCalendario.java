package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DiaDeCalendario")
public class EntidadDiaCalendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ejercicios;
    private LocalDate fecha;
    private Integer respuestas;
    private Long usuariosId;

    public EntidadDiaCalendario(Integer ejercicios, LocalDate fecha, Integer respuestas, Long usuariosId) {
        this.ejercicios = ejercicios;
        this.fecha = fecha;
        this.respuestas = respuestas;
        this.usuariosId = usuariosId;
    }
}