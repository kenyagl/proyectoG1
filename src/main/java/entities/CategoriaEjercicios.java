package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoriaEjercicios")
public class CategoriaEjercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriaEjercicios", nullable = false)
    private Integer id_CategoriaEjercicios;
    private String nombre;

    public CategoriaEjercicios(String nombre) {
        this.nombre = nombre;
    }
}
