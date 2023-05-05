package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Usuario;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ifxUsuarioSrvc {

    public Usuario buscarNombre(String nombre);
    List<Usuario> listaUsus();

    Optional<Usuario> findById(Long id);
}
