package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.EntidadPreguntas;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPreguntas extends CrudRepository<EntidadPreguntas, Long> {
}
