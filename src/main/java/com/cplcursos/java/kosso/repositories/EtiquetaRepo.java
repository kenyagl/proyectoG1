package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EtiquetaRepo extends JpaRepository<Etiqueta, Long> {

    List<Etiqueta> findByNombre(@Param("nombre") String nombre);
}
