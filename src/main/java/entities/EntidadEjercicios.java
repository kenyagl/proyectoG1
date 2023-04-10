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
@Table(name = "Ejericicios")
public class EntidadEjercicios{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dificultad;
    private String texto;
    private Integer puntosAcceso;
    private String respuestaTipo;

    public EntidadEjercicios(Integer dificultad, String texto, Integer puntosAcceso, String respuestaTipo) {
        this.dificultad = dificultad;
        this.texto = texto;
        this.puntosAcceso = puntosAcceso;
        this.respuestaTipo = respuestaTipo;
    }
}
