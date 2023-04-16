package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/version1")
public class UsuarioCtrl {

    @Autowired
    private UsuarioSrvcImpl usuSrvc;

    @GetMapping("/acceso")
    public String Acceso(Model modelo) {
        return "acceso";
    }

    @PostMapping("/login")
    public String comprobarAcceso(Model modelo, @RequestParam("usuario") String usu, @RequestParam("clave") String clave){
        String texto = "Hola "+ usu +". Tu clave es " + clave + ".";
        modelo.addAttribute("texto", texto);
        return "exitoLogin";
    }

    @GetMapping("/listausus")
    public String listaUsus(Model modelo){
        modelo.addAttribute("listausuarios", usuSrvc.listaUsus());
        return "listaUsus";
    }

    @GetMapping("/registro")
    public String Registro(Model modelo) {
        return "registro";
    }

    @PostMapping("/registro")
    public String alta(Model modelo){

        return "éxito";
    }

    @GetMapping("/perfil")
    public String Perfil(Model modelo) {
        return "perfil";
    }
}
