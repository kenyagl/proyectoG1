package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioCtrl {

    @Autowired
    private UsuarioSrvcImpl usuSrvc;

    @GetMapping("/listausus")
    public String listaUsus(Model modelo){
        modelo.addAttribute("listausuarios", usuSrvc.listaUsus());
        return "perfilesYUsuarios/listaUsus";
    }



    @GetMapping("/perfil")
    public String Perfil(Model modelo) {
        return "perfilesYUsuarios/perfil";
    }

}
