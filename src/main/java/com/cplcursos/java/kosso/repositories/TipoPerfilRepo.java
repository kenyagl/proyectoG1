package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.TipoPerfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TipoPerfilRepo extends CrudRepository<TipoPerfil, Long> {


    List<TipoPerfil> findByNombre(@Param("perfil") String perfil);

}