package com.cplcursos.java.kosso.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/preguntas")
public class PreguntaCtrl {

    @GetMapping(value = {"/", ""})
    public String replyPregunta (Model model){
        return "pregunta-list";
    }

    @GetMapping(value = "/save")
    public String mirarPregunta (Model model){ return "preguntaPublicada";} //Opción 1: PreguntaLista

    @PostMapping(value = "/save")
    public String savePregunta (Model model){ return "preguntaPublicada";} //Opción 2: PreguntaIndividual

    @GetMapping(value = "/pregunta") //Añadir el id de la pregunta
    public String showPreguntar (Model model){ return "preguntaPublicada";}

    @GetMapping(value = "/new")
    public String verPregunta (Model model){ return "pregunta-form";}
    @PostMapping(value = "/new")
    public String hacerPregunta (Model model){ return "pregunta-form";}

}
