package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.utils.FileLoadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {


    @Value("${upload.photos.ejercicios.dir}")
    String ejerciciosDir;
    @Value("${upload.photos.usuarios.dir}")
    String usuariosDir;
    @Value("${upload.photos.preguntas.dir}")
    String preguntasDir;



    @GetMapping("/user-photos/{userId}/{filename:.+}")
    @ResponseBody

    public ResponseEntity<Resource> serveUserImage(@PathVariable String userId, @PathVariable String filename) {

        // Cargamos el archivo como un recurso a través del servicio de almacenamiento predeterminado.
        Resource file = loadAsResource(usuariosDir + "/" + userId, filename);

        // Construimos una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta.
        // También establecemos el encabezado "Content-Disposition" con el nombre de archivo para indicar que se debe descargar.
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/ejercicio-photos/{userId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveEjercicioImage(@PathVariable String userId, @PathVariable String filename) {

        // Cargamos el archivo como un recurso a través del servicio de almacenamiento predeterminado.
        Resource file = loadAsResource(ejerciciosDir+ "/" + userId, filename);

        // Construimos una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta.
        // También establecemos el encabezado "Content-Disposition" con el nombre de archivo para indicar que se debe descargar.
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/pregunta-photos/{userId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> servePreguntaImage(@PathVariable String userId, @PathVariable String filename) {

        // Cargamos el archivo como un recurso a través del servicio de almacenamiento predeterminado.
        Resource file = loadAsResource(preguntasDir + "/" + userId, filename);

        // Construimos una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta.
        // También establecemos el encabezado "Content-Disposition" con el nombre de archivo para indicar que se debe descargar.
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }




    public Resource loadAsResource(String directorio, String filename) {
        FileLoadUtil fileLoadUtil = new FileLoadUtil();
        Resource resource = fileLoadUtil.load(directorio, filename);
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            return null;
        }
    }




}
