package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Comentario;
import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.entities.PuntosForo;
import com.cplcursos.java.kosso.entities.Respuesta;
import com.cplcursos.java.kosso.repositories.RespuestaRepo;
import com.cplcursos.java.kosso.services.ComentarioSrvc;
import com.cplcursos.java.kosso.services.PreguntaSrvc;
import com.cplcursos.java.kosso.services.RespuestaSrvc;
import com.cplcursos.java.kosso.services.VotosSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
    Gestiona los "me gusta" y "no me gusta" de toda la aplicación.

    A estas URLs se debería llegar únicamente desde llamadas AJAX.

    TODO: cualquier URL en otro controlador que gestiones los votos debería ser trasladado aquí
 */
@Controller
public class VotosCtrl {
    @Autowired
    private VotosSrvc votoSrvc;

    // Conectamos con los servicios de cada entidad que se puede votar
    @Autowired
    private PreguntaSrvc preguntaSrvc;
    @Autowired
    private RespuestaSrvc respuestaSrvc;

    @Autowired
    private ComentarioSrvc comentarioSrvc;


    // Votar pregunta
    @PostMapping("/votar")
    @ResponseBody
    // Permite devolver un objeto en el cuerpo de la respuesta HTTP a la llamada desde el js (fetch)
    public Map<String, Object> votar(@RequestParam Long idContenido, @RequestParam String tipo, @RequestParam Integer valor, Model model) {

        //Si no hay idContenido ni tipo, no se puede asignar el voto --> Lanzar condición de error
        if (idContenido == null || idContenido.describeConstable().isEmpty() || tipo == null || tipo.isEmpty()) {
            return Collections.emptyMap();
        }
        //Si valor es 0, no hay que hacer nada. Se puede indicar la situación o no al usuario
        if (valor == 0) {
            return Collections.emptyMap();
        }
        // creamos el objeto voto a asignar al contenido
        PuntosForo nuevoVoto = new PuntosForo();
        nuevoVoto.setFechaVoto(LocalDate.now());
        nuevoVoto.setPuntos(valor > 0 ? 25 : -25);


        int totalLikes = 0;
        int totalDislikes = 0;

        // Vemos qué tipo de contenido se está votando...
        switch (tipo) {

            case "votoPregunta":
                Optional<Pregunta> pregOP = preguntaSrvc.findById(idContenido);
                if (pregOP.isPresent()) {
                    Pregunta pregunta = pregOP.get();
                    pregunta.anexarVoto(nuevoVoto);
                    preguntaSrvc.save(pregunta);
                    totalLikes = pregunta.calcularLikes();
                    totalDislikes = pregunta.calcularDislikes();
                }
                break;
            case "votoRespuesta":
                Optional<Respuesta> respOP = respuestaSrvc.findById(idContenido);
                if (respOP.isPresent()) {
                    Respuesta respuesta = respOP.get();
                    respuesta.anexarVoto(nuevoVoto);
                    respuestaSrvc.save(respuesta);
                    totalLikes = respuesta.calcularLikes();
                    totalDislikes = respuesta.calcularDislikes();
                }
                break;
            case "votoComentario":
                Optional<Comentario> comentOP = comentarioSrvc.findById(idContenido);
                if (comentOP.isPresent()) {
                    Comentario comentario = comentOP.get();
                    comentario.anexarVoto(nuevoVoto);
                    comentarioSrvc.save(comentario);
                    totalLikes = comentario.calcularLikes();
                    totalDislikes = comentario.calcularDislikes();
                }
                break;
            default:
            }

        Map<String, Object> map = new HashMap<>();
        map.put("idContenido", idContenido);
        map.put("tipo", tipo);
        map.put("totalLikes", totalLikes);
        map.put("totalDisLikes", totalDislikes);

        return map;
    }
}
