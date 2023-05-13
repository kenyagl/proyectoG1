package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.PuntosForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PuntosForoRepo extends JpaRepository<PuntosForo, Long> {

    Long countByIdContenidoAndTipoContenido(Long idContenido, String tipoContenido);

    @Query("SELECT COUNT(a) from PuntosForo a WHERE a.puntos > 0 AND a.idContenido = ?1 AND a.tipoContenido = ?2")
    Integer cuentaLike(Long idContenido, String tipoContenido);

    @Query("SELECT COUNT(a) from PuntosForo a WHERE a.puntos < 0 AND a.idContenido = ?1 AND a.tipoContenido = ?2")
    Integer cuentaDislike(Long idContenido, String tipoContenido);
}