package com.cplcursos.java.kosso.entities;


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
@Table(name="Etiquetas")
public class Etiqueta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String nombre;

}

