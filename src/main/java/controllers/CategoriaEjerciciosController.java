package controllers;

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
@RequestMapping("/ejercicios")
public class CategoriaEjerciciosController {

    @GetMapping("")
    public String selectEjercicio (Model model){
        return "ejercicio";
    }

    @PostMapping("")
    public String createEjercicio (Model model){
        return "ejercicio";
    }
}
