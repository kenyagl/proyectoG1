package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainCtrl {

    @Autowired
    private UsuarioSrvcImpl usuSrvc;

    @GetMapping(value = {"/", "/home", ""})
    public String showHome() {
        if(!isAuthenticated()){
            return "home";
        }else{
            return "redirect:/homeLogged";
        }
    }

    @GetMapping("/homeLogged")
    public String showHomeLogged(@AuthenticationPrincipal MyUserDetails userDetails, Model modelo) {
        String email = userDetails.getUsername();
        Usuario usu = usuSrvc.findByEmail(email);

        modelo.addAttribute("usuario", usu);

        return "home";
    }

    @GetMapping("/login")
    public String acceso() {
        return "login";
    }

    @PostMapping("/loginprueba")
    public String comprobarAcceso(Model modelo, @RequestParam("usuario") String usu, @RequestParam("clave") String clave){
        String texto = "Hola "+ usu +". Tu clave es " + clave + ".";
        modelo.addAttribute("texto", texto);
        return "exitoLogin";
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

}
