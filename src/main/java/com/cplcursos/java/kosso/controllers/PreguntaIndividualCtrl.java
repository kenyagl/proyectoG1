package com.cplcursos.java.kosso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PreguntaIndividualCtrl {
    public String inicioTuProgeso (Model model){
        return "acesso";
    }
}