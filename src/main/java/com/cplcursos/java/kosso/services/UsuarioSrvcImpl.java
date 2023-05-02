package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Usuario> findById(Long id) {
        return usurepo.findById(id);
    }
}
