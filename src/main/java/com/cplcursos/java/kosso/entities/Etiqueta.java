package com.cplcursos.java.kosso.entities;

/**
 * The type Etiquetas.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Etiquetas")
public class EntidadEtiquetas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String nombre;

    public EntidadEtiquetas(String nombre) {
        this.nombre = nombre;
    }

}
*/
