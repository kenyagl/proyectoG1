package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.services.PreguntaSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/preguntas")
public class PreguntaCtrl {
    @Autowired
    private PreguntaSrvc preguntaSrvc;

    @GetMapping(value = {"/", ""})
    public String mostrarPreguntas (Model model){
        model.addAttribute("preguntas",preguntaSrvc.findAll());
        return "preguntas/pregunta-list";
    }

    // Muestra la pregunta publicada por su id
    // Hay un problema que desde la url http://localhost:8080/preguntas/ con la barra al final no muestra la pregunta publicada
    @GetMapping(value = "/preguntaPublicada/{id}")
    public String verPreguntaPublicada (@PathVariable Long id, Model model){
        Optional<Pregunta> pregunta = preguntaSrvc.findById(id);
        if(pregunta.isPresent()) {
            model.addAttribute("pregunta", pregunta.get());
            return "preguntas/preguntaPublicada";
        }
        return "Pregunta no existe";
    }

    // Publica la pregunta y la muestra
    @PostMapping(value = "/save")
    public String crearPregunta (@ModelAttribute("pregunta") Pregunta pregunta){
        if (pregunta.getFechaPregunta() == null){
            preguntaSrvc.setFecha(pregunta);
        }
        preguntaSrvc.save(pregunta);
        return "redirect:/preguntas/preguntaPublicada/" + pregunta.getId();
    }

    @GetMapping(value = "/edit/{id}")
    public String editarPregunta( @PathVariable("id") Long id, Model model){
        Optional<Pregunta> pregunta = preguntaSrvc.findById(id);
        if(pregunta.isPresent()){
            model.addAttribute("pregunta", pregunta.get());
        }
        else{
            return "error-page";
        }
        return "preguntas/pregunta-form";
    }

    @GetMapping(value = "/new")
    public String verFormularioPregunta (Model model){
        model.addAttribute("pregunta", new Pregunta());
        return "preguntas/pregunta-form";
    }

    @PostMapping("/new")
    public String guardarPregunta (@PathVariable("id") Long id, Model model){
        model.addAttribute("pregunta", preguntaSrvc.encontrarPregunta(id));
        return "preguntas/preguntaPublicada";
    }

    @GetMapping(value = "/delete/{id}")
    public String borrarPregunta (@PathVariable("id") Long id){
        preguntaSrvc.borrarPregunta(id);
        return "redirect:/preguntas";
    }

    // Controlador para votos




}
