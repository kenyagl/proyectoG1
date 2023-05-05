package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EjercicioRepo extends JpaRepository<EjercicioOpMul, Long> {
}
