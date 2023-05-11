package com.cplcursos.java.kosso.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "Por favor, introduce tu nombre")
    private String firstName;

    @NotEmpty(message = "Por favor, introduce tus apellidos")
    private String lastName;

    @NotEmpty(message = "Por favor, introduce tu contraseña")
    private String password;

    @NotEmpty(message = "Por favor, introduce tu email")
    @Email(message = "Por favor, introduce un email válido")
    private String email;

    public UsuarioDTO() {
    }
}
