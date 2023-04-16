package com.cplcursos.java.kosso.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class PerfilCtrl {

    @GetMapping(value= {"", "/"})
    public String consultaPerfil (Model model){
        return "perfil";
    }

    @GetMapping("/editar")
    public String verPerfilForm (Model model){
        return "perfil-form";
    }

    @PostMapping("/editar")
    public String editarPerfil (Model model){
        return "perfil-form";
    }


    @GetMapping("/borrarperfil") // NO sabemos muy bien si poner este get hasta que tengamos la funcion de borrar perfil
    public String perfilEliminado (Model model){
        return "index";
    }

    @DeleteMapping("/borrarperfil")
    public String eliminarperfil (Model model){
        return "index";
    }

    @GetMapping("/ejercicios")
    public String irejercicios (Model model){
        return "MenuEjercicios";
    }

    @GetMapping("/pregunta")
    public String irpreguntas (Model model){
        return "pregunta-list";
    }

}





