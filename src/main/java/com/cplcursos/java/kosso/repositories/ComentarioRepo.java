package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepo extends JpaRepository<Comentario, Long> {
}
