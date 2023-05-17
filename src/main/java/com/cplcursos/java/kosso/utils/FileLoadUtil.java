package com.cplcursos.java.kosso.utils;



import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLoadUtil {



    public Resource load( String path, String filename) {
        try {
            //Crea un objeto "Path" para controlar los directorios o ficheros. En este caso, el nombre del fichero a
            // recoger.

            Path file = Paths.get(path).resolve(filename);
            //Crea un objeto recurso, convirtiendo el objeto a data:URI
            Resource resource = new UrlResource(file.toUri());
            //Si el objeto recurso se ha creado correctamente y se puede leer, lo devuelve al servicio de Streaming
            // para ser servido como objeto Mono (objeto de Stream).
            if (resource.exists() &&  resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("No se pudo leer el archivo!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


}
