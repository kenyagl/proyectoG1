package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.services.PreguntaSrvc;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/preguntas")
public class PreguntaCtrl {
@Autowired
private PreguntaSrvc preguntaSrvc;

    @GetMapping(value = {"/", ""})
    public String replyPregunta (Model model){
        return "pregunta-list";
    }

    @GetMapping(value = "/save")
    public String mirarPregunta (Model model){ return "preguntaPublicada";} //Opción 1: PreguntaLista

    @PostMapping(value = "/save")
    public String savePregunta (@ModelAttribute("pregunta") Pregunta pregunta){
        preguntaSrvc.savePregunta(pregunta);
        return "redirect:/preguntaPublicada";
    } //Opción 2: PreguntaIndividual

    @GetMapping(value = "/pregunta") //Añadir el id de la pregunta
    public String showPreguntar (Model model){ return "preguntaPublicada";}

    @GetMapping(value = "/new")
    public String verPregunta (Model model){
        model.addAttribute("pregunta", new Pregunta());
        return "pregunta-form";
    }

    @GetMapping("/new")
    public String guardarPregunta (@PathVariable("id") Long id, Model model){
        model.addAttribute("pregunta", preguntaSrvc.encontrarPregunta(id));
        return "preguntaPublicada";
    }
      @DeleteMapping(value = "/delete" )
    public String borrarPregunta (@PathVariable("id") Long id){
        preguntaSrvc.borrarPregunta(id);
        return "pregunta-list";
    }









}
