package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.DTO.UsuarioDTO;
import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxUsuarioSrvc {

    Optional<Usuario> buscarNombre(String nombre);

    Usuario save(Usuario usu);
    void saveDto(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> listaUsus();

    Optional<Usuario> findById(Long id);

    Usuario findByEmail(String email);

    void deleteByEmail(String email);

    void deleteById(Long id);

    List<Usuario> findAll();

    List<Usuario> ordenarPorPuntos(List<Usuario> listaNoOrdenada);

    Usuario findByAuth(MyUserDetails myUserDetails);

    boolean isAuthenticated();
}
