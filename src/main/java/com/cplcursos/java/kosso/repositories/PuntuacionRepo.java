package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PuntuacionRepo extends JpaRepository<Puntuacion, Long> {

    List<Puntuacion> findByName(@Param("nombre") String nombre);
}