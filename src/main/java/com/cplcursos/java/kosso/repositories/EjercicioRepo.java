package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EjercicioRepo extends JpaRepository<EjercicioOpMul, Long> {

    @Query("SELECT e FROM EjercicioOpMul e JOIN e.categorias c WHERE c.nombre LIKE %?1%")
    public List<EjercicioOpMul> encontrarEjerPorCategoria(String keyword);




}
