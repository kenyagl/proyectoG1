package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.DTO.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MainCtrl {

    @GetMapping(value = {"/", "/home", ""})
    public String showHome() {
        return "home";
    }

    @GetMapping("/login")
    public String acceso() {
        return "login";
    }

    @PostMapping("/loginprueba")
    public String comprobarAcceso(Model modelo, @RequestParam("usuario") String usu, @RequestParam("clave") String clave){
        String texto = "Hola "+ usu +". Tu clave es " + clave + ".";
        modelo.addAttribute("texto", texto);
        return "exitoLogin";
    }

}
