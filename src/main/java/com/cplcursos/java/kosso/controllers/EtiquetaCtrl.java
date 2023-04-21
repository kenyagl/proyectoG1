package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Etiqueta;
import com.cplcursos.java.kosso.services.EtiquetaSrvc;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/etiquetas")
public class EtiquetaCtrl {
    @Autowired
    private EtiquetaSrvc etiquetaSrvc;


    @GetMapping(value = {"/", ""})
    public String showEtiquetas(Model model) {
        model.addAttribute("etiquetas", etiquetaSrvc.findAll());
        return "null";
    }

    @GetMapping("/new")
    public String NewEtiqueta(Model model) {
        model.addAttribute("etiqueta", new Etiqueta());
        return "null";
    }

    @PostMapping("/save")
    public String saveEtiqueta(@ModelAttribute("etiqueta") Etiqueta etiqueta) {
       etiquetaSrvc.save(etiqueta);
        return "null";
    }

    @GetMapping("/edit/{id}")
    public String showEditEtiqueta(@PathVariable("id") Long id, Model model) {
        Optional<Etiqueta> etiqueta = etiquetaSrvc.findById(id);
        if(etiqueta.isPresent()){
            model.addAttribute("etiqueta", etiqueta);
        } else {
            return "Ha tag no existe" + id;
        }
        return "null";
    }

    @GetMapping("/delete/{id}")
    public String deleteEtiqueta(@PathVariable("id") Long id) {
        etiquetaSrvc.deleteById(id);
        return "null";
    }
}
