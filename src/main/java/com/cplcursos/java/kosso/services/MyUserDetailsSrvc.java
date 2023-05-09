package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.Rol;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsSrvc implements UserDetailsService {

    private Usuario user;

    @Autowired
    private UsuarioRepo userRepository;

    public MyUserDetailsSrvc(UsuarioRepo userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(email);

        if (user != null) {
            return new MyUserDetails(user);
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    /*private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(List<Rol> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }*/
}