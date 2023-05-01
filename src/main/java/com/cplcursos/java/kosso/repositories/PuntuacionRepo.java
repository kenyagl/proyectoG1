package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PuntuacionRepo extends JpaRepository<Puntuacion, Long> {
}