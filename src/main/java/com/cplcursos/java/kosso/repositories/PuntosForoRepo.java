package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.PuntosForo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntosForoRepo extends JpaRepository<PuntosForo, Long> {

    Long countByIdContenidoAndTipoContenido(Long idContenido, String tipoContenido);
}