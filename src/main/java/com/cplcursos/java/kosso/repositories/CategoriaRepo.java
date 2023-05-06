package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {
    List<Categoria> findByNombre(@Param("nombre") String nombre);
}
