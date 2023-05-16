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
        if(!usuSrvc.isAuthenticated()){
            return "home";
        }else{
            return "redirect:/homeLogged";
        }
    }

    @GetMapping("/homeLogged")
    public String showHomeLogged(@AuthenticationPrincipal MyUserDetails userDetails, Model modelo) {

        modelo.addAttribute("usuario", usuSrvc.findByAuth(userDetails));

        return "home";
    }

    @GetMapping("/login")
    public String acceso() {
        return "login";
    }

}
