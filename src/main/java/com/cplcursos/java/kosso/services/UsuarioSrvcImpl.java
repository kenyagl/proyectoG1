package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioSrvcImpl implements ifxUsuarioSrvc {

    @Autowired
    private UsuarioRepo usurepo;

    @Override
    public Usuario buscarNombre(String nombre) {
       return null;
    }

    @Override
    public List<Usuario> listaUsus() {
        return usurepo.findAll();
    }
}
