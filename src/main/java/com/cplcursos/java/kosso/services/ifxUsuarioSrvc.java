package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Usuario;

import java.util.List;

public interface ifxUsuarioSrvc {

    public Usuario buscarNombre(String nombre);
    List<Usuario> listaUsus();
}
