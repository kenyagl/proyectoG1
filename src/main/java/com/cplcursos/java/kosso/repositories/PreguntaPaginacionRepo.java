package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Pregunta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaPaginacionRepo extends PagingAndSortingRepository<Pregunta, Long> {
    Page<Pregunta> findAllByTituloPreguntaContainingOrTextoPreguntaContaining(String search, String search1, Pageable pagina);

}