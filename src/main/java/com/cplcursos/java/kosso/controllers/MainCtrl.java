package com.cplcursos.java.kosso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {

    @GetMapping(value = {"/", "/home", ""})
    public String showHome() {
        return "home";
    }

}
