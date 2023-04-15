package controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/ejercicios")
public class EjerciciosController {
    @GetMapping(value = {"/", ""})
    public String showEjercicios() {
        return "menuEjercicios";
    }

    @GetMapping("/ejercicio1")
    public String showEjercicio1() {
        return "ejercicioSeleccionMultiple";
    }
}
