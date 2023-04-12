package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/version1")
public class UsuarioCtrl {

    @GetMapping("/acceso")
    public String Acceso(Model modelo) {
        return "index";
    }

    @PostMapping("/acceso")
    public String Login(Model modelo) {
        return "accedido";
    }

    @GetMapping("/registro")
    public String Registro(Model modelo) {
        return "Registro";
    }

    @GetMapping("/perfil")
    public String Perfil(Model modelo) {
        return "perfil";
    }
}
