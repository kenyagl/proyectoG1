package com.cplcursos.java.kosso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainCtrl {

    @GetMapping(value = {"/", "/home", ""})
    public String showHome() {
        return "home";
    }

    @GetMapping("/login")
    public String Acceso(Model modelo) {
        return "login";
    }

    @PostMapping("/loginprueba")
    public String comprobarAcceso(Model modelo, @RequestParam("usuario") String usu, @RequestParam("clave") String clave){
        String texto = "Hola "+ usu +". Tu clave es " + clave + ".";
        modelo.addAttribute("texto", texto);
        return "exitoLogin";
    }

    @GetMapping("/registro")
    public String registro(Model modelo) {

        return "registro";
    }

    @PostMapping("/registro")
    public String alta(Model modelo){

        return "exitoLogin";
    }
}
