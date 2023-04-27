package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Puntuacion;
import com.cplcursos.java.kosso.services.PuntuacionSrvc;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/puntuacion")


public class PuntuacionCtrl {

    @Autowired
    private PuntuacionSrvc puntuacionSrvc;


    @GetMapping(value = {"/", ""})
    public String showPuntuacion(Model model) {
        model.addAttribute("puntuacion", puntuacionSrvc.findAll());
        return "null";
    }

    @GetMapping("/new")
    public String NewPuntuacion(Model model) {
        model.addAttribute("puntuacion", new Puntuacion());
        return "null";
    }

    @PostMapping("/save")
    public String savePuntuacion(@ModelAttribute("puntuacion") Puntuacion puntuacion) {
        puntuacionSrvc.save(puntuacion);
        return "null";
    }

    @GetMapping("/edit/{id}")
    public String showEditPuntuacion(@PathVariable("id") Long id, Model model) {
        Optional<Puntuacion> puntuacion = puntuacionSrvc.findById(id);
        if(puntuacion.isPresent()){
            model.addAttribute("puntuacion", puntuacion);
        } else {
            return "La puntuacion " + id + " no existe";
        }
        return "null";
    }

    @GetMapping("/delete/{id}")
    public String deletePuntuacion(@PathVariable("id") Long id) {
        puntuacionSrvc.deleteById(id);
        return "null";
    }
}
