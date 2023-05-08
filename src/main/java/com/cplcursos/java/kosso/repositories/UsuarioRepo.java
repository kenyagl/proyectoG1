package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String name);
    Usuario findByEmail(String email);
}
