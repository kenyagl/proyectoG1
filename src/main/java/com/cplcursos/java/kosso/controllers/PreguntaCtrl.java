package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.*;
import com.cplcursos.java.kosso.repositories.PreguntaPaginacionRepo;
import com.cplcursos.java.kosso.services.*;
import com.cplcursos.java.kosso.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequestMapping("/preguntas")
public class PreguntaCtrl {
    @Autowired
    private PreguntaSrvc preguntaSrvc;

    @Autowired
    private RespuestaSrvc respuestaSrvc;

    @Autowired
    private ComentarioSrvc comentarioSrvc;

    @Autowired
    private CategoriaSrvc categoriaSrvc;

    @Autowired
    private PreguntaPaginacionRepo preguntaPaginacionRepo;


    @GetMapping(value = {"/", ""})
    public String mostrarPreguntas (Model model,
                                    @RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size
    )
    {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Pregunta> paginaPreguntas = preguntaPaginacionRepo.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("paginaPreguntas", paginaPreguntas);

        int totalPaginas = paginaPreguntas.getTotalPages();

        if (totalPaginas > 0) {
            List<Integer> numeroPaginas = IntStream.rangeClosed(1, totalPaginas)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("numeroPaginas", numeroPaginas);
        }

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
    public String crearPregunta (@ModelAttribute("pregunta") Pregunta pregunta, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName1 = multipartFile.getOriginalFilename();

        if(fileName1 == null){
            fileName1 = pregunta.getTituloPregunta() + "default.png";
        }
        String fileName = StringUtils.cleanPath(fileName1);
        pregunta.setFoto(fileName);

        if (pregunta.getFechaPregunta() == null){
            preguntaSrvc.setFecha(pregunta);
        }

        Pregunta preguntaGuardada = preguntaSrvc.save(pregunta);
        String uploadDir = "target/classes/static/image/pregunta-photos/" + preguntaGuardada.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "redirect:/preguntas/preguntaPublicada/" + pregunta.getId();
    }

// agregar al edit las categorias que ya tenía la pregunta
    @GetMapping(value = "/edit/{id}")
    public String editarPregunta( @PathVariable("id") Long id, Model model){
        Optional<Pregunta> pregunta = preguntaSrvc.findById(id);
        if(pregunta.isPresent()){
            model.addAttribute("pregunta", pregunta.get());
            model.addAttribute("categorias", categoriaSrvc.findAll());

        }
        else{
            return "error-page";
        }
        return "preguntas/pregunta-form";
    }

    @GetMapping(value = "/new")
    public String verFormularioPregunta (Model model){
        model.addAttribute("pregunta", new Pregunta());
        model.addAttribute("categorias", categoriaSrvc.findAll());
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

    // Controlador para Respuestas

    @PostMapping(value = "/respuestasave")
    public String crearRespuesta (@RequestParam(name = "idPregunta") Long id, @RequestParam(name = "textoRespuesta") String textoRespuesta, Model model){
        Respuesta respuesta = new Respuesta();
        Pregunta pregunta = new Pregunta();
        pregunta.setId(id);
        respuesta.setPregunta(pregunta);
        respuesta.setTextoRespuesta(textoRespuesta);
        respuesta.setFechaRespuesta(LocalDate.now());
        respuestaSrvc.save(respuesta);
        return "redirect:/preguntas/preguntaPublicada/" + id;
    }

    // Controlador para Comentarios
    @PostMapping(value = "/comentariosave")
    public String crearComentario(@RequestParam(name = "idPregunta") Long idPregunta, @RequestParam(name = "idRespuesta") Long idRespuesta, @RequestParam(name = "textoComentario") String textoComentario, Model model){
        Comentario comentario = new Comentario();
        Respuesta respuesta = new Respuesta();
        respuesta.setId(idRespuesta);

        comentario.setRespuesta(respuesta);
        comentario.setTextoComentario(textoComentario);
        comentario.setFechaComentario(LocalDate.now());
        comentarioSrvc.save(comentario);
        return "redirect:/preguntas/preguntaPublicada/" + idPregunta;
    }


    // Controladores de votos
    // Votos Preguntas
    @PostMapping(value = "/cuentavotospregunta")
    public String cuentaVotosPreg(@RequestParam(name = "valor") Integer votos, @RequestParam(name = "idPregunta") Long id, Model model){
        Optional<Pregunta> preOp = preguntaSrvc.findById(id);
        if(preOp.isPresent()){
            Pregunta pregunta = preOp.get();
            Integer acumulados = pregunta.getVotos();
            if (acumulados == null){
                acumulados = 0;
            }
            pregunta.setVotos(votos + acumulados);
            model.addAttribute("sumaP", pregunta.getVotos());
            preguntaSrvc.save(pregunta);
        }
        else{
            return "error-page";
        }
        return "/preguntas/bloqueAjaxVotos :: votosPregunta";
    }

    // Votos Respuestas
    @PostMapping(value = "/cuentavotosrespuesta")
    public String cuentaVotosResp(@RequestParam(name = "valor") Integer votos, @RequestParam(name = "idRespuesta") Long id, Model model){
        Optional<Respuesta> respOp = respuestaSrvc.findById(id);
        if(respOp.isPresent()){
            Respuesta respuesta = respOp.get();
            Integer acumulados = respuesta.getVotos();
            if (acumulados == null){
                acumulados = 0;
            }
            respuesta.setVotos(votos + acumulados);
            model.addAttribute("sumaR", respuesta.getVotos());
            respuestaSrvc.save(respuesta);
        }
        else{
            return "error-page";
        }
        return "/preguntas/bloqueAjaxVotos :: votosRespuesta";
    }

    // Votos Comentarios

    @PostMapping(value = "/cuentavotoscomentario")
    public String cuentaVotosComen(@RequestParam(name = "valor") Integer votos, @RequestParam(name = "idComentario") Long id, Model model){
        Optional<Comentario> comenOp = comentarioSrvc.findById(id);
        if(comenOp.isPresent()){
            Comentario comentario = comenOp.get();
            Integer acumulados = comentario.getVotos();
            if (acumulados == null){
                acumulados = 0;
            }
            comentario.setVotos(votos + acumulados);
            model.addAttribute("sumaC", comentario.getVotos());
            comentarioSrvc.save(comentario);
        }
        else{
            return "error-page";
        }
        return "/preguntas/bloqueAjaxVotos :: votosComentario";
    }



}
