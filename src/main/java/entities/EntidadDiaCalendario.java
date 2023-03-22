package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


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
    private Date fecha;
    private Integer respuestas;
    private Long usuariosId;
    public EntidadDiaCalendario(Integer ejercicios, Date fecha, Integer respuestas) {
        this.ejercicios = ejercicios;
        this.fecha = fecha;
        this.respuestas = respuestas;
    }
}
