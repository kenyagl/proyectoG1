package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RespuestaRepo extends JpaRepository<Respuesta, Long> {

   Respuesta findByPregunta_Id(Long id);
}
