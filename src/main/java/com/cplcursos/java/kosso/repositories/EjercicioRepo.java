package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepo extends JpaRepository<EjercicioOpMul, Long> {
}
