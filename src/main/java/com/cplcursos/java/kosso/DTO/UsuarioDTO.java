package com.cplcursos.java.kosso.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.*;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Por favor, introduce tu contraseña")
    private String password;

    @NotEmpty(message = "Por favor, introduce tu email")
    @Email(message = "Por favor, introduce un email válido")
    private String email;

    public UsuarioDTO() {
    }
}
