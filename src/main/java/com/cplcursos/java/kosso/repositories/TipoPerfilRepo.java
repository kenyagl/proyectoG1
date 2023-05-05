package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.TipoPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TipoPerfilRepo extends JpaRepository<TipoPerfil, Long> {

        List<TipoPerfil> findByPerfil(@Param("perfil") String perfil);

}