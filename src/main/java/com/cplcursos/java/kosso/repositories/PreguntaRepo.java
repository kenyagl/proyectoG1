package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreguntaRepo extends JpaRepository<Pregunta, Long> {


}