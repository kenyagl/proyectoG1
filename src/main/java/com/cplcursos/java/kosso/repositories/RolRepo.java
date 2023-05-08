package com.cplcursos.java.kosso.repositories;

import com.cplcursos.java.kosso.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepo extends JpaRepository<Rol, Long> {

    Optional<Rol> findByName(String name);
}
