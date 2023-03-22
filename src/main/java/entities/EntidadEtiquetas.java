package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Etiquetas.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Etiquetas")
public class EntidadEtiquetas {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String nombre;

    /**
     * Instantiates a new Customer.
     *
     * @param nombre               the name
     */
    public EntidadEtiquetas(String nombre) {
        this.nombre = nombre;
    }

}
