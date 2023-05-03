package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Comentario;
import com.cplcursos.java.kosso.entities.Etiqueta;
import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.entities.Respuesta;
import com.cplcursos.java.kosso.repositories.RespuestaRepo;
import com.cplcursos.java.kosso.services.ComentarioSrvc;
import com.cplcursos.java.kosso.services.EtiquetaSrvc;
import com.cplcursos.java.kosso.services.PreguntaSrvc;
import com.cplcursos.java.kosso.services.RespuestaSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/preguntas")
public class PreguntaCtrl {
    @Autowired
    private RespuestaRepo respuestaRepo;

    @Autowired
    private PreguntaSrvc preguntaSrvc;

    @Autowired
    private RespuestaSrvc respuestaSrvc;

    @Autowired
    private ComentarioSrvc comentarioSrvc;

    @Autowired
    private EtiquetaSrvc etiquetaSrvc;

    @GetMapping(value = {"/", ""})
    public String mostrarPreguntas (Model model){
        model.addAttribute("preguntas",preguntaSrvc.findAll());
        return "preguntas/pregunta-list";
    }

    // Muestra la pregunta publicada por su id
    @GetMapping(value = "/preguntaPublicada/{id}")
    public String verPreguntaPublicada (@PathVariable Long id, Model model){
        Optional<Pregunta> pregunta = preguntaSrvc.findById(id);
        if(pregunta.isPresent()) {
            model.addAttribute("pregunta", pregunta.get());
            return "preguntas/preguntaPublicada";
        }
        return "Pregunta no existe";
    }

    // Publica la pregunta y la muestra
    @PostMapping(value = "/save")
    public String crearPregunta (@ModelAttribute("pregunta") Pregunta pregunta){
        if (pregunta.getFechaPregunta() == null){
            preguntaSrvc.setFecha(pregunta);
        }

        preguntaSrvc.save(pregunta);
        return "redirect:/preguntas/preguntaPublicada/" + pregunta.getId();
    }


    @GetMapping(value = "/edit/{id}")
    public String editarPregunta( @PathVariable("id") Long id, Model model){
        Optional<Pregunta> pregunta = preguntaSrvc.findById(id);
        if(pregunta.isPresent()){
            model.addAttribute("pregunta", pregunta.get());
        }
        else{
            return "error-page";
        }
        return "preguntas/pregunta-form";
    }

    @GetMapping(value = "/new")
    public String verFormularioPregunta (Model model){
        model.addAttribute("pregunta", new Pregunta());

        return "preguntas/pregunta-form";
    }

    @PostMapping("/new")
    public String guardarPregunta (@PathVariable("id") Long id, Model model){
        model.addAttribute("pregunta", preguntaSrvc.findById(id));
        return "preguntas/preguntaPublicada";
    }

    @GetMapping(value = "/delete/{id}")
    public String borrarPregunta (@PathVariable("id") Long id){
        preguntaSrvc.borrarPregunta(id);
        return "redirect:/preguntas";
    }

    // Controladores para Respuestas

    @PostMapping(value = "/respuestasave")
    public String crearRespuesta (@RequestParam(name = "idPregunta") Long id, @RequestParam(name = "textoRespuesta") String textoRespuesta, Model model){
        Respuesta respuesta = new Respuesta();
        Pregunta pregunta = new Pregunta();
        pregunta.setId(id);
        respuesta.setPregunta(pregunta);
        respuesta.setTextoRespuesta(textoRespuesta);
        respuesta.setFechaRespuesta(LocalDate.now());

        respuestaSrvc.save(respuesta);
        return "redirect:/preguntas/preguntaPublicada/" + pregunta.getId();
    }

    // Controladores Comentarios
    @PostMapping(value = "/comentariosave")
    public String crearComentario(@RequestParam(name = "idPregunta") Long idPregunta,/* @RequestParam(name = "idRespuesta") Long idRespuesta,*/ @RequestParam(name = "textoComentario") String textoComentario, Model model){
        Pregunta pregunta = new Pregunta();
        Comentario comentario = new Comentario();
        pregunta.setId(idPregunta);

        // Problema cuando hay más de dos respuestas
        Respuesta respuesta = respuestaRepo.findByPregunta_Id(idPregunta);

        comentario.setRespuesta(respuesta);
        comentario.setTextoComentario(textoComentario);
        comentario.setFechaComentario(LocalDate.now());


        comentarioSrvc.save(comentario);
        return "redirect:/preguntas/preguntaPublicada/" + idPregunta;
    }



}
