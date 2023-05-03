package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.RespuestaEjId;
import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RespuestaEjOpMulRepo extends JpaRepository<RespuestaEjOpMul, Long> {
    List<RespuestaEjOpMul> findByFechaRespuestaBetween(LocalDateTime startDate, LocalDateTime endDate);
}