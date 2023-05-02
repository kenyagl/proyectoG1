package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.CategoriaEjercicios;
import com.cplcursos.java.kosso.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CategoriaRepo extends JpaRepository<CategoriaEjercicios, Integer> {
    List<CategoriaEjercicios> findByNombre(@Param("nombre") String nombre);
}
