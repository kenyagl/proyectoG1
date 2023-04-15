package com.cplcursos.java.kosso.repositories;
import com.cplcursos.java.kosso.entities.EntidadTiposPerfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The interface Customer repository.
 */
public interface RepositorioTiposPerfil extends CrudRepository<EntidadTiposPerfil, Integer> {

    /**
     *
     * @param perfil the name
     * @return the list
     */
    List<EntidadTiposPerfil> findByName(@Param("perfil") String perfil);

}
