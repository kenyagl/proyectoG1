package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.*;
import com.cplcursos.java.kosso.utils.FileUploadUtil;
import com.cplcursos.java.kosso.services.CategoriaSrvc;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    //Creo un usuario fake para probar el guardar respuesta, ya que sin la autenticación configurada el usuario no está presente
    Usuario usu = new Usuario(1L, 200, 100);
    Integer totalusu = usu.getPuntosEjercicios() + usu.getPuntosRespuestas();


    @GetMapping(value = {"/", ""})
    public String showEjercicios(Model model, @Param("keyword") String keyword) {
        //Este método devuelve .findAll si no se le pasa ninguna keyword
        List<EjercicioOpMul> ejerciciosResult = ejerciciosService.encontrarEjerPorCategoria(keyword);

        model.addAttribute("ejercicios", ejerciciosResult);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalusu", totalusu);
        model.addAttribute("categorias", categoriaSrvc.findAll());

        return "ejercicios/menuEjercicios";
    }

    /*@GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<EjercicioOpMul> ejerciciosResult = ejerciciosService.encontrarEjerPorCategoria(keyword);
        model.addAttribute("ejercicios", ejerciciosResult);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalusu", totalusu);
        return "ejercicios/menuEjercicios";
    }*/

    @GetMapping("/{id}")
    public String showEjercicio(@PathVariable("id") Long id, Model model) {
        Optional<EjercicioOpMul> ejercicioOpMulOptional = ejerciciosService.findById(id);
        if (ejercicioOpMulOptional.isPresent()) {

            EjercicioOpMul ejercicioOpMul = ejercicioOpMulOptional.get();
            model.addAttribute("ejercicio", ejercicioOpMul);
            model.addAttribute("id_usuario", usu.getId());
            model.addAttribute("totalusu", totalusu);

            Long idNextEjer = ejerciciosService.findIdNextEjercicio(id);

            model.addAttribute("idNextEjer", idNextEjer);

            if(idNextEjer == null){
                //Hacer algo
            }else{
                Optional<EjercicioOpMul> nextEjerOp = ejerciciosService.findById(idNextEjer);
                if(nextEjerOp.isEmpty()){
                    //Hacer algo
                }else{
                    EjercicioOpMul nextEjer = nextEjerOp.get();
                    model.addAttribute("puntoAccesoNext", nextEjer.getPuntosAcceso());
                }
            }

        } else {
            return "errorEncontrandoEjercicio";
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
                                @RequestParam("image") MultipartFile imagen
                                ) throws IOException {

        String fileName1 = imagen.getOriginalFilename();
        if(fileName1 == null){
            fileName1 = "default.png";
        }

        String fileName = StringUtils.cleanPath(fileName1);

        ejercicioOpMul.setImagen(fileName);

        EjercicioOpMul savedEjer = ejerciciosService.save(ejercicioOpMul);

        String uploadDir = "image/ejercicio-photos/" + savedEjer.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, imagen);

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
}
