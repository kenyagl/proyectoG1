package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.repositories.UsuarioIfx;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioSrvcImpl implements ifxUsuarioSrvc {

    @Autowired
    private UsuarioIfx usurepo;

    @Override
    public Usuario buscarNombre(String nombre) {
       return null;
    }

    @Override
    public List<Usuario> listaUsus() {
        return usurepo.findAll();
    }
}
