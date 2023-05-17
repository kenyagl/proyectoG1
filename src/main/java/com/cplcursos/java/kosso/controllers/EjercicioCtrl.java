package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.*;
import com.cplcursos.java.kosso.utils.FileUploadUtil;
import com.cplcursos.java.kosso.services.CategoriaSrvc;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    @GetMapping(value = {"/", ""})
    public String showEjercicios(@AuthenticationPrincipal MyUserDetails userDetails, Model model, @Param("keyword") String keyword) {
        Usuario usu = usuarioSrvc.findByAuth(userDetails);

        List<EjercicioOpMul> ejerciciosResult = ejerciciosService.encontrarEjerPorCategoria(keyword);

        model.addAttribute("ejercicios", ejerciciosResult);
        model.addAttribute("keyword", keyword);
        model.addAttribute("usuario", usu);
        model.addAttribute("totalusu", usuarioSrvc.totalPuntos(usu));
        model.addAttribute("categorias", categoriaSrvc.findAll());

        return "ejercicios/menuEjercicios";
    }

    @GetMapping("/{id}")
    public String showEjercicio(@AuthenticationPrincipal MyUserDetails userDetails, @PathVariable("id") Long id, Model model) {

        Usuario usu = usuarioSrvc.findByAuth(userDetails);

        Optional<EjercicioOpMul> ejercicioOpMulOptional = ejerciciosService.findById(id);
        if (ejercicioOpMulOptional.isPresent()) {

            EjercicioOpMul ejercicioOpMul = ejercicioOpMulOptional.get();
            model.addAttribute("ejercicio", ejercicioOpMul);
            model.addAttribute("usuario", usu);
            model.addAttribute("id_usuario", usu.getId());
            model.addAttribute("totalusu", usuarioSrvc.totalPuntos(usu));

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
                                @RequestParam("image") MultipartFile imagen
    ) throws IOException {

        String fileName1 = imagen.getOriginalFilename();
        if (fileName1 == null) {
            fileName1 = " ";
        }

        String fileName = StringUtils.cleanPath(fileName1);

        ejercicioOpMul.setImagen(fileName);

        EjercicioOpMul savedEjer = ejerciciosService.save(ejercicioOpMul);

        String uploadDir = "src/main/resources/static/image/ejercicio-photos/" + savedEjer.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, imagen);

        String uploadDir2 = "target/classes/static/image/ejercicio-photos/" + savedEjer.getId();
        FileUploadUtil.saveFile(uploadDir2, fileName, imagen);

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
    @ResponseBody   // Permite devolver un objeto en el cuerpo de la respuesta HTTP a la llamada desde el js (fetch)
    public Map<String, Object> saveRespuesta(@PathVariable("id") Long idEjercicio,
                                             @RequestParam(name = "resp") String miRespuesta,
                                             @RequestParam(name = "id_usuario") Long idUsuario,
                                             Model model) {
        // La variable map es un objeto que contendrá toda la información a devolver a la llamada fetch
        Map<String, Object> map = new HashMap<String, Object>();

        // Aplicamos estilo de programación funcional al Optional...
        // leer https://blog.adamgamboa.dev/es/como-utilizar-java-optional/
        ejerciciosService.findById(idEjercicio).ifPresentOrElse(
                ejer -> {
                    if(miRespuesta.equals(ejer.getRespuestaCorrecta())){
                        map.put("acierto", true);
                        usuarioSrvc.findById(idUsuario).ifPresentOrElse(
                                usu -> {
                                    usu.setPuntosEjercicios(usu.getPuntosEjercicios() + 100);
                                    RespuestaEjOpMul respuestaEjOpMul = new RespuestaEjOpMul(
                                            new IdRespuestaEj(ejer, usu),
                                            miRespuesta,
                                            LocalDateTime.now()
                                    );
                                    respuestaEjOpMulSrvc.saveAndFlush(respuestaEjOpMul);
                                },
                                () -> { map.put("error", "No se encuentra el usuario.");}
                        );
                    } else {
                        map.put("acierto", false);
                    };
                },
                () -> { map.put("error", "No se encuentra el ejercicio.");}
        );
        // No devolvemos el mensaje de correcto o incorrecto para que se pueda internacionalizar con thymeleaf.
        // La plantilla necesita saber únicamente si la respuesta es correcta o no para poner el mensaje en el
        // idioma correspondiente.
        // Utilizamos "msg" en caso de error.
        // Por otra parte, así, si se quiere modificar el mensaje, no hay que cambiar el código del controlador.
        return map;

    }
}
