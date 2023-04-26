package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;

import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/ejercicios")
public class EjercicioCtrl {
    @Autowired
    private EjerciciosSrvc ejerciciosService;

    @Autowired
    private RespuestaEjOpMulSrvc respuestaEjOpMulSrvc;

    @GetMapping(value = {"/", ""})
    public String showEjercicios(Model model) {
        Usuario usu = new Usuario();
        usu.setPuntosEjercicios(1);
        usu.setPuntosRespuestas(2);
        int totalusu = usu.getPuntosEjercicios() + usu.getPuntosRespuestas();

        model.addAttribute("ejercicios",ejerciciosService.findAll() );
        model.addAttribute("totalusu", totalusu);
        //return "ejercicios/ejercicio-list";
        return "ejercicios/menuEjercicios";
    }

    @GetMapping("/{id}")
    public String showEjercicio(@PathVariable("id") Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMulOptional = ejerciciosService.findById(id);
        if(ejercicioOpMulOptional.isPresent()){
            EjercicioOpMul ejercicioOpMul = ejercicioOpMulOptional.get();
            model.addAttribute("ejercicio", ejercicioOpMul);
        } else {
            return "errorEncontrandoEjercicio";
        }
        return "ejercicios/ejercicioOpMul";
    }

    @GetMapping("/new")
    public String showNewEjercicioForm(Model model) {
        model .addAttribute("ejercicioOpMul", new EjercicioOpMul());
        return "ejercicios/ejercicioForm";
    }

    @PostMapping("/save")
    public String saveEjercicio(@ModelAttribute("ejercicioOpMul") EjercicioOpMul ejercicioOpMul) {
        ejerciciosService.save(ejercicioOpMul);
        return "redirect:/ejercicios/";
    }

    @GetMapping("/edit/{id}")
    public String showEditEjercicioForm(@PathVariable ("id") Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMul = ejerciciosService.findById(id);
        if(ejercicioOpMul.isPresent()){
            model.addAttribute("ejercicioOpMul", ejercicioOpMul);
        } else {
            return "errorEncontrandoEjercicio";
        }
        return "ejercicios/ejercicioForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteEjercicio(@PathVariable("id") Long id) {
        ejerciciosService.deleteById(id);
        return "redirect:/ejercicios/";
    }

    @GetMapping("/{id}/next")
    public String nextEjercicio(@PathVariable Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMul = ejerciciosService.findNextEjercicio(id);
        if(ejercicioOpMul.isPresent()) {
            model.addAttribute("ejercicio", ejercicioOpMul.get());
        } else {
            return "errorEncontrandoEjercicio";
        }
        return "ejercicios/ejercicioOpMul";
    }

    /*
    *
    ****************** CONTROLADORES DE RESPUESTAS A CADA EJERCICIO ******************
    *
    * PREGUNTA: podría hacer una clase anidada aquí dentro para ponerle antes el @RequestMapping("/{id}/respuesta")?
    *
     */

    @PostMapping("/{id}/respuesta/save")
    public String saveRespuesta(@ModelAttribute("respuestaEjOpMul") RespuestaEjOpMul respuestaEjOpMul) {
        respuestaEjOpMulSrvc.save(respuestaEjOpMul);
        return "redirect:/ejercicios/";
    }

    @GetMapping("/{id}/respuesta/edit")
    public String showEditRespuesta(@PathVariable("id") Long id, Model model) {
        Optional<com.cplcursos.java.kosso.entities.RespuestaEjOpMul> respuestaEjercicioOpMul = respuestaEjOpMulSrvc.findById(id);
        if(respuestaEjercicioOpMul.isPresent()){
            model.addAttribute("respuestaEjOpMul", respuestaEjercicioOpMul);
        } else {
            return "errorEncontrandoEjercicio";
        }
        return "ejercicios/ejercicioOpMul";
    }

    @GetMapping("/{id}/respuesta/delete")
    public String deleteRespuesta(@PathVariable("id") Long id) {
        ejerciciosService.deleteById(id);
        return "redirect:/ejercicios/";
    }
}
