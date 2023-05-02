package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.entities.IdRespuestaEj;
import com.cplcursos.java.kosso.repositories.EjercicioRepo;
import com.cplcursos.java.kosso.services.CategoriaSrvc;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@Log4j2
@RequestMapping("/ejercicios")
public class EjercicioCtrl {
    @Autowired
    private EjerciciosSrvc ejerciciosService;

    @Autowired
    private RespuestaEjOpMulSrvc respuestaEjOpMulSrvc;

    @Autowired
    private CategoriaSrvc categoriaSrvc;

    @Autowired
    private UsuarioSrvcImpl usuarioSrvc;

    //Creo un usuario fake para probar el guardar respuesta, ya que sin la autenticación configurada el usuario no está presente
    Usuario usu = new Usuario(1L, 200, 100);
    Integer totalusu = usu.getPuntosEjercicios() + usu.getPuntosRespuestas();


    @GetMapping(value = {"/", ""})
    public String showEjercicios(Model model) {

        model.addAttribute("ejercicios", ejerciciosService.findAll());
        model.addAttribute("totalusu", totalusu);
        //return "ejercicios/ejercicio-list";
        return "ejercicios/menuEjercicios";
    }

    @GetMapping("/{id}")
    public String showEjercicio(@PathVariable("id") Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMulOptional = ejerciciosService.findById(id);
        if (ejercicioOpMulOptional.isPresent()) {

            EjercicioOpMul ejercicioOpMul = ejercicioOpMulOptional.get();
            model.addAttribute("ejercicio", ejercicioOpMul);
            model.addAttribute("id_usuario", usu.getId());
            model.addAttribute("totalusu", totalusu);

            //Añado el siguiente ejercicio
            EjercicioOpMul ejer = ejercicioOpMulOptional.get();
            Long idNextEjer = ejerciciosService.findIdNextEjercicio(ejer.getId());
            Optional<EjercicioOpMul> nextEjerOp = ejerciciosService.findById(idNextEjer);
            if (nextEjerOp.isPresent()) {
                EjercicioOpMul nextEjer = nextEjerOp.get();
                model.addAttribute("nextEjer", nextEjer);
            } else {
                return "errorEncontrandoEjercicio";
            }

        } else {
            return "errorEncontrandoEjercicio";
        }
        return "ejercicios/ejercicioOpMul";
    }

    @GetMapping("/new")
    public String showNewEjercicioForm(Model model) {
        model.addAttribute("ejercicio", new EjercicioOpMul());
        model.addAttribute("categoriasEj", categoriaSrvc.findAll());
        return "ejercicios/ejercicioForm";
    }

    @PostMapping("/save")
    public String saveEjercicio(@ModelAttribute("ejercicioOpMul") EjercicioOpMul ejercicioOpMul) {
        ejerciciosService.save(ejercicioOpMul);
        return "redirect:/ejercicios/";
    }

    @GetMapping("/edit/{id}")
    public String showEditEjercicioForm(@PathVariable("id") Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMul = ejerciciosService.findById(id);
        if (ejercicioOpMul.isPresent()) {
            model.addAttribute("ejercicioOpMul", ejercicioOpMul);
        } else {
            return "errorEncontrandoEjercicio";
        }
        return "ejercicios/ejercicioForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteEjercicio(@PathVariable("id") Long id) {
        ejerciciosService.deleteById(id);
        return "redirect:/ejercicios/";
    }

    /*
     *
     ****************** CONTROLADOR DE RESPUESTAS A CADA EJERCICIO ******************
     *
     * PREGUNTA: podría hacer una clase anidada aquí dentro para ponerle antes el @RequestMapping("/{id}/respuesta")?
     *
     */

    @PostMapping("/{id}/respuesta/save")
    public String saveRespuesta(@PathVariable("id") Long idEjercicio,
                                @RequestParam(name = "resp") String miRespuesta,
                                @RequestParam(name = "id_usuario") Long idUsuario,
                                Model model) {

        Optional<EjercicioOpMul> ejer = ejerciciosService.findById(idEjercicio);

        if (ejer.isEmpty()) {
            return "errorEncontrandoEjercicio";
        }

        EjercicioOpMul ejercicio = ejer.get();

        String respuestaCorrecta = ejercicio.getRespuestaCorrecta();

        String resultMessage;

        if (miRespuesta.equals(respuestaCorrecta)) {
            resultMessage = "¡Muy bien! Tu respuesta es correcta.";

            Optional<Usuario> usuOp = usuarioSrvc.findById(idUsuario);

            if (usuOp.isEmpty()) {
                return "error";
            }

            Usuario usuario = usuOp.get();
            usuario.setPuntosEjercicios(usuario.getPuntosEjercicios() + 100);

            RespuestaEjOpMul respuestaEjOpMul = new RespuestaEjOpMul(new IdRespuestaEj(ejercicio, usuario), miRespuesta, LocalDateTime.now());
            respuestaEjOpMulSrvc.saveAndFlush(respuestaEjOpMul);

        } else {
            resultMessage = "Lo siento, tu respuesta no es correcta.";
        }

        model.addAttribute("resultMessage", resultMessage);
        return "partesAjax :: resultadoRespuesta";
    }
    /*

            // Falta meter el usuario con la securización
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Optional<Usuario> usuario = usuarioSrvc.findById(authentication.getId());

            */
}
