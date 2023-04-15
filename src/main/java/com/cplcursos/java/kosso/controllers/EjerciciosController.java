package com.cplcursos.java.kosso.controllers;
/*
import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cplcursos.java.kosso.services.EjerciciosService;

@Controller
@Log4j2
@RequestMapping("/ejercicios")
public class EjerciciosController {
    @Autowired
    private EjerciciosService ejerciciosService;

    @GetMapping(value = {"/", ""})
    public String showEjercicios(Model model) {
        model.addAttribute("ejercicios", ejerciciosService.findAll());
        //return "ejerciciosList";
        return "menuEjercicios";
    }

    @GetMapping("/ejercicioEjemplo")
    public String showEjercicio1() {
        return "ejercicioOpcionMultiple";
    }

    @GetMapping("/newOpMul")
    public String showNewEjercicioForm(Model model) {
        model .addAttribute("ejercicioOpMul", new EjercicioOpMul());
        return "ejercicioForm";
    }

    @PostMapping("/saveOpMul")
    public String saveEjercicio(@ModelAttribute("ejercicioOpMul") EjercicioOpMul ejercicioOpMul) {
        ejerciciosService.save(ejercicioOpMul);
        return "redirect:/ejercicios/";
    }

    @GetMapping("/editOpMul/{id}")
    public String showEditEjercicioForm(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("ejercicioOpMul", ejerciciosService.findById(id));
        return "ejercicioForm";
    }

    @GetMapping("/deleteOpMul/{id}")
    public String deleteEjercicio(@PathVariable("id") Long id) {
        ejerciciosService.deleteById(id);
        return "redirect:/ejercicios/";
    }
}
*/