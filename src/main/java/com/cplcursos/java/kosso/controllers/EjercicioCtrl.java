package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.IdRespuestaEj;
import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.services.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
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

    @Autowired
    private FileSystemStorageServiceImpl fileSystemStorageService;


    @GetMapping(value = {"/", ""})
    public String showEjercicios(@AuthenticationPrincipal MyUserDetails userDetails, Model model, @Param("keyword") String keyword) {
        String userEmail = userDetails.getUsername();
        Usuario usu = usuarioSrvc.findByEmail(userEmail);
        Integer totalusu = usuarioSrvc.totalPuntos(usu);

        List<EjercicioOpMul> ejerciciosResult = ejerciciosService.encontrarEjerPorCategoria(keyword);

        model.addAttribute("ejercicios", ejerciciosResult);
        model.addAttribute("keyword", keyword);
        model.addAttribute("usuario", usu);
        model.addAttribute("totalusu", totalusu);
        model.addAttribute("categorias", categoriaSrvc.findAll());

        return "ejercicios/menuEjercicios";
    }

    @GetMapping("/{id}")
    public String showEjercicio(@AuthenticationPrincipal MyUserDetails userDetails, @PathVariable("id") Long id, Model model) {
        String userEmail = userDetails.getUsername();
        Usuario usu = usuarioSrvc.findByEmail(userEmail);
        Integer totalusu = usuarioSrvc.totalPuntos(usu);

        Optional<EjercicioOpMul> ejercicioOpMulOptional = ejerciciosService.findById(id);
        if (ejercicioOpMulOptional.isPresent()) {

            EjercicioOpMul ejercicioOpMul = ejercicioOpMulOptional.get();
            model.addAttribute("ejercicio", ejercicioOpMul);
            model.addAttribute("usuario", usu);
            model.addAttribute("id_usuario", usu.getId());
            model.addAttribute("totalusu", totalusu);

            Long idNextEjer = ejerciciosService.findIdNextEjercicio(id);

            if(idNextEjer == null) {
                idNextEjer = ejercicioOpMul.getId();
            }

            model.addAttribute("idNextEjer", idNextEjer);

        } else {
            return "error/error";
        }
        return "ejercicios/ejercicioOpMul";
    }

    @GetMapping("/new")
    public String showNewEjercicioForm(Model model) {
        model.addAttribute("ejercicio", new EjercicioOpMul());
        model.addAttribute("categorias", categoriaSrvc.findAll());
        return "ejercicios/ejercicioForm";
    }

    @PostMapping("/save")
    public String saveEjercicio(@ModelAttribute EjercicioOpMul ejercicioOpMul,
                                @RequestParam("image") MultipartFile imagen, Model modelo
    ){

        String fileName1 = imagen.getOriginalFilename();
        if (fileName1 == null) {
            fileName1 = " ";
        }

        String fileName = StringUtils.cleanPath(fileName1);

        ejercicioOpMul.setImagen(fileName);
        ejercicioOpMul.setRutaFoto("src/main/resources/static/image/ejercicio-photos/" + ejercicioOpMul.getId() + "/" + fileName);

        modelo.addAttribute("ejercicio", ejercicioOpMul);
        fileSystemStorageService.save(imagen);

        ejercicioOpMul.setRutaFoto("/image/" + fileName);
        EjercicioOpMul savedEjer = ejerciciosService.save(ejercicioOpMul);

        return "redirect:/ejercicios/";
    }

    @GetMapping("/edit/{id}")
    public String showEditEjercicioForm(@PathVariable("id") Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMul = ejerciciosService.findById(id);
        if (ejercicioOpMul.isPresent()) {
            model.addAttribute("ejercicioOpMul", ejercicioOpMul);
        } else {
            return "error/error";
        }
        return "ejercicios/ejercicioForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteEjercicio(@PathVariable("id") Long id) {
        ejerciciosService.deleteById(id);
        return "redirect:/ejercicios/";
    }

    /**************** CONTROLADOR DE RESPUESTAS A CADA EJERCICIO ******************/
    @PostMapping("/{id}/respuesta/save")
    public String saveRespuesta(@PathVariable("id") Long idEjercicio,
                                @RequestParam(name = "resp") String miRespuesta,
                                @RequestParam(name = "id_usuario") Long idUsuario,
                                Model model) {

        Optional<EjercicioOpMul> ejer = ejerciciosService.findById(idEjercicio);

        if (ejer.isEmpty()) {
            return "error/error";
        }

        EjercicioOpMul ejercicio = ejer.get();

        String respuestaCorrecta = ejercicio.getRespuestaCorrecta();

        String resultMessage;

        if (miRespuesta.equals(respuestaCorrecta)) {
            resultMessage = "¡Muy bien! Tu respuesta es correcta.";

            Optional<Usuario> usuOp = usuarioSrvc.findById(idUsuario);

            if (usuOp.isEmpty()) {
                return "error/error";
            }

            Usuario usuario = usuOp.get();
            usuario.setPuntosEjercicios(usuario.getPuntosEjercicios() + 100);

            RespuestaEjOpMul respuestaEjOpMul = new RespuestaEjOpMul(new IdRespuestaEj(ejercicio, usuario), miRespuesta, LocalDateTime.now());
            respuestaEjOpMulSrvc.saveAndFlush(respuestaEjOpMul);

        } else {
            resultMessage = "¡OH NO! Tu respuesta no es correcta. \n ¡Vuélvelo a intentar!";
        }

        model.addAttribute("resultMessage", resultMessage);
        return "components/partesAjax :: resultadoRespuesta";
    }
}
