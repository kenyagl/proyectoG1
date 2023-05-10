package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
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
    private String clave;
    private String nombre;
    private String apellidos;
    private String descripcion;
    private String foto;
    private Boolean activo = false;
    private Date creadoEl;
    private String acercaDe;
    private Integer puntosEjercicios;
    private Integer puntosRespuestas;
    
    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, Integer puntosEjercicios, Integer puntosRespuestas) {
        this.id = id;
        this.puntosEjercicios = puntosEjercicios;
        this.puntosRespuestas = puntosRespuestas;
    }

    @Transient
    public String getPhotosImagePath() {
        if (foto == null || id == null) return null;

        return "/user-photos/" + id + "/" + foto;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DiaCalendario> diaCalendario = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Pregunta> preguntas;

    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany
    private List<RespuestaEjOpMul> respuestasEj;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Rol> roles = new ArrayList<>();

}
