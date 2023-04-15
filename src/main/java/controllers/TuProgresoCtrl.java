package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TuProgresoCtrl {
    public String inicioTuProgeso (Model model){
        return "acesso";
    }
}