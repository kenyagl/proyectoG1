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
@Table(name = "puntuacion")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Puntuacion", nullable = false)
    private Long id;

    private Long puntosTotales;
    private Long puntosEjercicios;
    private Long puntosRespuestas;

    private Long idUsusario;

    public Puntuacion(Long puntosTotales, Long puntosEjercicios, Long puntosRespuestas) {
        this.puntosTotales = puntosTotales;
        this.puntosEjercicios = puntosEjercicios;
        this.puntosRespuestas = puntosRespuestas;
    }
}
