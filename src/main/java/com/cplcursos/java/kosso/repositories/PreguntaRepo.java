package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Pregunta;
import org.springframework.data.repository.CrudRepository;

public interface PreguntaRepo extends CrudRepository<Pregunta, Long> {
}