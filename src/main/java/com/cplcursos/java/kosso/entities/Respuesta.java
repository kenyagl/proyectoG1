package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean alerta;

    @Column(length = 500)
    private String textoRespuesta;

    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "respuesta", cascade = CascadeType.ALL)
    private List<Comentario> comentario;

    @ManyToOne
    @JoinColumn(name = "idPregunta", referencedColumnName = "id")
    private Pregunta pregunta;

    // Relacion con votos
    @OneToMany(mappedBy = "respuesta", cascade = CascadeType.ALL)
    private Set<PuntosForo> puntos;

    public Respuesta(Boolean alerta, String textoRespuesta) {
        this.alerta = alerta;
        this.textoRespuesta = textoRespuesta;
    }

    public void anexarVoto(PuntosForo voto){
        voto.setRespuesta(this);
        this.puntos.add(voto);
    }

    public int calcularLikes(){
        int totalVotos = 0;
        for( PuntosForo pf : puntos ){
            if(pf.getPuntos() == 25){
                totalVotos++;
            }
        }
        return totalVotos;
    }
    public int calcularDislikes(){
        int totalVotos = 0;
        for( PuntosForo pf : puntos ){
            if(pf.getPuntos() == -25){
                totalVotos++;
            }
        }
        return totalVotos;
    }
}