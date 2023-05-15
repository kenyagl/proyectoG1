package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.FileInfo;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;
import com.cplcursos.java.kosso.services.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Controlador encargado de manejar la carga de archivos.
 * La clase utiliza las anotaciones @Controller y @CrossOrigin para definir que es un controlador de Spring y
 * permitir solicitudes CORS desde el servidor web localhost en el puerto 8080.
 * La clase utiliza la inyección de dependencias (@Autowired) para acceder a los servicios necesarios para la carga
 * y almacenamiento de archivos, así como para el acceso a la base de datos de archivos.
 */
@Controller
@CrossOrigin("http://localhost:8080")
public class FileController {

    /**
     * Servicio de almacenamiento de archivos en FileSystem local utilizado por el controlador.
     */
    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Autowired
    private EjerciciosSrvc ejerciciosSrvc;

    /**
     * Servicio de almacenamiento de archivos en la base de datos utilizado por el controlador.
     */
   /* @Autowired
    private DBFileStorageService dbFileStorageService;*/

    /**
     * Servicio de usuario utilizado por el controlador.
     */
    //   @Autowired
    //  private ifxUsuarioSrvc userService;

    /**
     * Constructor de la clase que recibe el servicio de almacenamiento de archivos como parámetro.
     * La anotación @Autowired se utiliza para inyectar automáticamente el servicio necesario al crear una instancia de la clase.
     *
     * @param fileSystemStorageService el servicio de almacenamiento de archivos a utilizar
     */
    @Autowired
    public FileController(FileSystemStorageService fileSystemStorageService) {
        this.fileSystemStorageService = fileSystemStorageService;
    }


    /**
     * Método que se encarga de listar los archivos que han sido subidos al servidor.
     *
     * @param model el modelo que se va a utilizar para pasar los datos a la vista
     * @return el nombre de la vista a la que se va a redirigir
     * @throws IOException si ocurre un error al cargar los archivos
     */
    @GetMapping("/files")
    public String listAllUploadedFiles(Model model,Authentication authentication) throws IOException {

        //        Obtenemos todos los archivos almacenados en el servicio de almacenamiento predeterminado.
        //       Para cada archivo, generamos una URL que permita descargar el archivo desde el servidor.
        List<FileInfo> files = fileSystemStorageService.loadAll();
//
        //       Obtenemos todos los archivos almacenados en el servicio de almacenamiento de la base de datos.
        //       Para cada archivo, generamos una URL que permita descargar el archivo desde el servidor.
        //List<FileInfo> dbFiles = dbFileStorageService.getAllFileInfos();
//
        //      Obtenemos el nombre de usuario del objeto de autenticacion
        //    String username = authentication.getName();
        //        Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
        //      Usuario user = userService.buscaPorNombre(username);
//
        //        Obtenemos todos los archivos asociados al usuario y almacenados en la base de datos
        //        Para cada archivo, generamos una URL que permita descargar el archivo desde el servidor.
        // List<FileInfo> dbUserFiles = dbFileStorageService.getUserFileInfos(user);

        //       Agregamos las URLs de los archivos del servicio de almacenamiento predeterminado al modelo.
        model.addAttribute("files", files);

        //      Agregamos los objetos FileInfo del servicio de almacenamiento de la base de datos al modelo.
        // model.addAttribute("DBfiles", dbFiles);

        //    model.addAttribute("dbUserFiles", dbUserFiles);


        //        Devolvemos el nombre de la vista a la que se va a redirigir.
        return "listFicheros";
    }


    /**
     * Método que se encarga de descargar un archivo desde el servidor.
     *
     * @param filename el nombre del archivo que se va a descargar
     * @return una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta '@GetMapping("/files/{filename:.+}")' es una anotación utilizada en un método dentro de un controlador de Spring MVC que indica que el método manejará solicitudes GET para una URL que incluya una variable de ruta {filename}. El . + en la variable de ruta indica que la variable puede contener un punto y cualquier otro carácter después de él. Esto es necesario porque algunos nombres de archivo pueden contener puntos en su nombre y la expresión regular predeterminada utilizada por Spring no permitiría estos caracteres. Por ejemplo, si la URL solicitada es /files/myfile.txt, la variable de ruta {filename} será igual a myfile.txt. Si la URL solicitada es /files/myfile.pdf, la variable de ruta {filename} también será igual a myfile.pdf.
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        //       Cargamos el archivo como un recurso a través del servicio de almacenamiento predeterminado.
        Resource file = fileSystemStorageService.loadAsResource(filename);

        //       Construimos una respuesta HTTP con el archivo a descargar en el cuerpo de la respuesta.
        //       También establecemos el encabezado "Content-Disposition" con el nombre de archivo para indicar que se debe descargar.
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    /**
     * Método que se encarga de manejar la subida de un archivo al servidor.
     *
     * @param file               el archivo que se va a subir
     * @param redirectAttributes los atributos que se van a utilizar para pasar información entre solicitudes
     * @return el nombre de la vista a la que se va a redirigir
     */
    @PostMapping("/contenido/nuevo-contenido/uploadToFileSystem/{id}")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable Long id, Model modelo) {

        Optional<EjercicioOpMul> ejOptional = ejerciciosSrvc.findById(id);
        if (ejOptional.isPresent()) {
            EjercicioOpMul ej1 = ejOptional.get();
            modelo.addAttribute("ejercicio", ej1);
            ej1.setRutaFoto("/image/" + file.getOriginalFilename());
            ejerciciosSrvc.save(ej1);
        } else {
            return "error/error";
        }
        //        Guardamos el archivo en el servicio de almacenamiento predeterminado.
        fileSystemStorageService.save(file);


        return "ejercicios/ejercicioForm";
    }


    @GetMapping("/files/delete/{fileName}")
    public String deleteFileFromFileSystem(@PathVariable String fileName) {
        fileSystemStorageService.deleteFile(fileName);
        return "redirect:/files";
    }

//    @GetMapping("/databasefiles/desasociarUserFile/{id}")
//    public String deleteFileFromFileSystem(@PathVariable String id, Authentication authentication) {
// //        Obtenemos el nombre de usuario del usuario autenticado.
//        String username = authentication.getName();
// //        Buscamos al usuario correspondiente al nombre de usuario obtenido anteriormente.
//        User user = userService.findUserByEmail(username);
//
//        dbFileStorageService.desasociarUserFile(id, user);
//        return "redirect:/files";
//    }







    /**
     * Controlador de excepción para la excepción FileNotFoundException.
     * Retorna una respuesta con un estado HTTP 404 (no encontrado).
     *
     * @param exc la excepción FileNotFoundException que se ha producido
     * @return ResponseEntity con un estado HTTP 404 (no encontrado)
     */
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(FileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }


}