package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.time.LocalDate;
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
    private Boolean activo;
    private LocalDate creadoEl;
    private Integer puntosEjercicios;
    private Integer puntosRespuestas;
    
    public Usuario(Long id) {
        this.id = id;
    }

    @Transient
    public String getPhotosImagePath() {
        if (foto == null || id == null){
            return "/image/default-avatar.png";
        }

        return "/user-photos/" + id + "/" + foto;
    }


    public String mensajeHola(){
        return "Perfil de " + nombre;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DiaCalendario> diaCalendario = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Pregunta> preguntas;

    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<PuntosForo> puntosForoList;

    @OneToMany
    private List<RespuestaEjOpMul> respuestasEj;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Rol> roles = new ArrayList<>();

    public Integer calcularPuntosForo(){
        Integer totalPuntos = 0;
        for (PuntosForo puntosForo : puntosForoList ){
            totalPuntos += puntosForo.getPuntos();
        }
        return totalPuntos;
    }
}
