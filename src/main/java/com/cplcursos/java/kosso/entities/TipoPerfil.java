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
public class TipoPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String perfil;


    public TipoPerfil(String perfil) {
        this.perfil = perfil;
    }
}
