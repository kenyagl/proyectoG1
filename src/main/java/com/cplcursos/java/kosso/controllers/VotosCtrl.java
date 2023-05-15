package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.Pregunta;
import com.cplcursos.java.kosso.entities.PuntosForo;
import com.cplcursos.java.kosso.repositories.PreguntaRepo;
import com.cplcursos.java.kosso.services.PreguntaSrvc;
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
import java.util.Set;

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
    private PreguntaSrvc pregSrvc;
    //private PreguntaRepo pregRepo;

    // Votar pregunta
    @PostMapping("/votar")
    @ResponseBody
     // Permite devolver un objeto en el cuerpo de la respuesta HTTP a la llamada desde el js (fetch)
    public Map<String, Object> votar(@RequestParam Long idContenido, @RequestParam String tipo, @RequestParam Integer valor, Model model){

        // TODO Si no hay idContenido ni tipo, no se puede asignar el voto --> Lanzar condición de error
        // TODO Si valor es 0, no hay que hacer nada. Se puede indicar la situación o no al usuario

        // Vemos qué tipo de contenido se está votando...
        switch (tipo) {
            //... y creamos el objeto voto a asignar a ese contenido
            case "votoPregunta":
                // TODO findById devuelve un Optional. Debe tratarse el caso de que sea nulo lanzando un error
                 Pregunta preg = pregSrvc.findById(idContenido).get();

                PuntosForo nuevoVoto = new PuntosForo();
                nuevoVoto.setFechaVoto(LocalDate.now());
                nuevoVoto.setPuntos(valor > 0 ? 25 : -25);
                preg.anexarVoto(nuevoVoto);
                pregSrvc.save(preg);

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("idContenido", idContenido);
                map.put("tipo", tipo);
                map.put("totalLikes", preg.calcularLikes());
                map.put("totalDisLikes", preg.calcularDislikes());
                return map;
            case "votoRespuesta":
                break;
            case "votoComentario":
                break;
            default:
        }

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("idContenido", idContenido);
//        map.put("tipo", tipo);
//        map.put("totalLikes", votoSrvc.likesPregunta(idContenido));
//        map.put("totalDisLikes", votoSrvc.dislikesPregunta(idContenido));
//        //...llegarán a la llamada FETCH de js como un objeto tipo array de parejas "clave": "valor"


        return Collections.emptyMap();
    }



    // Votar respuesta

    // votar comentario
}
