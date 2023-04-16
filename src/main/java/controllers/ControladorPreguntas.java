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
@RequestMapping("/preguntas")
public class ControladorPreguntas {

    @GetMapping(value = {"/", ""})
    public String replyPregunta (Model model){
        return "pegunta";
    }

    @PostMapping(value = {"/", ""})
    public String selectPregunta (Model model){
        return "pegunta";
    }

    @GetMapping(value = "/preguntar")
    public String showPreguntar (Model model){ return "preguntar";}

    @PostMapping(value = "/save")
    public String savePregunta (Model model){ return "pregunta";}

}
