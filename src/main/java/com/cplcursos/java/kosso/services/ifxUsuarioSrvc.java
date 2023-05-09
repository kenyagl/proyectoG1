package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.DTO.UsuarioDTO;
import com.cplcursos.java.kosso.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxUsuarioSrvc {

    Optional<Usuario> buscarNombre(String nombre);
    void save(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listaUsus();

    Optional<Usuario> findById(Long id);

    Usuario findByEmail(String email);
}
