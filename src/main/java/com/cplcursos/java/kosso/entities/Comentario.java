package com.cplcursos.java.kosso.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String textoComentario;

    // Relacion con votos
    @OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL)
    private Set<PuntosForo> puntos;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaComentario;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRespuesta", referencedColumnName = "id")
    private Respuesta respuesta;


    public void anexarVoto(PuntosForo voto){
        voto.setComentario(this);
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
