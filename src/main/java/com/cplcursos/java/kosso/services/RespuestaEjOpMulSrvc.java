package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.entities.RespuestaEjercicioOpMul;
import com.cplcursos.java.kosso.repositories.RespuestaEjOpMulRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaEjOpMulSrvc {
    @Autowired
    private RespuestaEjOpMulRepo respuestaEjOpMulRepo;

    public List<RespuestaEjercicioOpMul> findAll() {
        return respuestaEjOpMulRepo.findAll();
    }

    public Optional<RespuestaEjercicioOpMul> findById(Long id) {
        return respuestaEjOpMulRepo.findById(id);
    }

    public RespuestaEjercicioOpMul save(RespuestaEjercicioOpMul respuestaEjercicioOpMul) {
        return respuestaEjOpMulRepo.save(respuestaEjercicioOpMul);
    }

    public void deleteById(Long id) {
        respuestaEjOpMulRepo.deleteById(id);
    }
}
