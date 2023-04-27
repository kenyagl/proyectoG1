package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String nombre;
    private String clave;
    private String rol;
    private String foto;
    private Boolean activo = false;
    private Date creadoEl;
    private String acercaDe;
    private Integer puntosEjercicios;
    private Integer puntosRespuestas;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<DiaCalendario> diaCalendario = new ArrayList<>();

}
