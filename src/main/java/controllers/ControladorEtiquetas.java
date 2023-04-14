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
@RequestMapping("/etiquetas")
public class ControladorEtiquetas {

    @GetMapping("")
    public String getEtiqueta (Model model){
        return "etiqueta";
    }

    @PostMapping("")
    public String selectEtiqueta (Model model){
        return "etiqueta";
    }
}
