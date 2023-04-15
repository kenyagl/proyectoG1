package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioIfx extends JpaRepository<Usuario, Long> {
}
