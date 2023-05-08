package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.DTO.UsuarioDTO;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioCtrl {

    @Autowired
    private UsuarioSrvcImpl usuSrvc;

    @GetMapping("/listausus")
    public String listaUsus(Model modelo){
        modelo.addAttribute("listausuarios", usuSrvc.listaUsus());
        return "perfilesYUsuarios/listaUsus";
    }
    @GetMapping("/perfil")
    public String Perfil(Model modelo) {
        return "perfilesYUsuarios/perfil";
    }

    @GetMapping("/registro")
    public String registro(Model modelo) {
        UsuarioDTO usuDTO = new UsuarioDTO();
        modelo.addAttribute("usuario", usuDTO);
        return "registro";
    }

    @PostMapping("/registro/save")
    public String registerUserAccount(@Valid @ModelAttribute("usuario") UsuarioDTO usuarioDTO,
                                            BindingResult result, Model modelo) {

        Usuario yaRegistrado = usuSrvc.findByEmail(usuarioDTO.getEmail());

        if (yaRegistrado != null) {
            result.rejectValue("email", null, "Ya existe un usuario registrado con ese email");
        }

        if(result.hasErrors()){
            modelo.addAttribute("usuario", usuarioDTO);
            return "/registro";
        }

        usuSrvc.save(usuarioDTO);
        return "redirect:/usuario/registro?success";
    }

}
