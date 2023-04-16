package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
