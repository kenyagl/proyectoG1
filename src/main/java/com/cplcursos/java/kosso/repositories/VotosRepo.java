package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.PuntosForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotosRepo extends JpaRepository<PuntosForo, Long> {

    /* TODO se puede parametrizar la consulta según el tipo de contenido y reducir el nro. de métodos mediante
        Criteria API con queries dinámicas
     */
    @Query("SELECT COUNT(pf) FROM PuntosForo pf WHERE pf.id = ?1 AND pf.pregunta IS NOT NULL AND pf.puntos > 0")
    Integer totalLikesPregunta(Long idContenido);
    @Query("SELECT COUNT(pf) FROM PuntosForo pf WHERE pf.id = ?1 AND pf.pregunta IS NOT NULL AND pf.puntos < 0")
    Integer totalDisLikesPregunta(Long idContenido);
    @Query("SELECT COUNT(pf) FROM PuntosForo pf WHERE pf.id = ?1 AND pf.respuesta IS NOT NULL AND pf.puntos > 0")
    Integer totalLikesRespuesta(Long idContenido);
    @Query("SELECT COUNT(pf) FROM PuntosForo pf WHERE pf.id = ?1 AND pf.respuesta IS NOT NULL AND pf.puntos < 0")
    Integer totalDisLikesRespuesta(Long idContenido);
    @Query("SELECT COUNT(pf) FROM PuntosForo pf WHERE pf.id = ?1 AND pf.comentario IS NOT NULL AND pf.puntos > 0")
    Integer totalLikesComentario(Long idContenido);
    @Query("SELECT COUNT(pf) FROM PuntosForo pf WHERE pf.id = ?1 AND pf.comentario IS NOT NULL AND pf.puntos < 0")
    Integer totalDisLikesComentario(Long idContenido);
}
