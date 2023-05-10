package com.cplcursos.java.kosso.services;

import com.cplcursos.java.kosso.DTO.UsuarioDTO;
import com.cplcursos.java.kosso.entities.Rol;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.repositories.RolRepo;
import com.cplcursos.java.kosso.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioSrvcImpl implements ifxUsuarioSrvc {

    @Autowired
    private UsuarioRepo usurepo;

    @Autowired
    private RolRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<Usuario> buscarNombre(String nombre) {
       return usurepo.findByNombre(nombre);
    }

    @Override
    public Usuario save(Usuario usu){
        return usurepo.save(usu);
    }

    @Override
    public void saveDto(UsuarioDTO userDTO) {
        Usuario user = new Usuario();
        user.setNombre(userDTO.getFirstName());
        user.setApellidos(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setClave(passwordEncoder.encode(userDTO.getPassword()));
        user.setPuntosEjercicios(100);
        user.setPuntosRespuestas(0);

        Optional<Rol> rolOp = roleRepository.findByName("ADMIN");
        Rol rol;
        if(rolOp.isPresent()){
            rol = rolOp.get();
        }else{
            rol = checkRoleExist();
        }
        user.setRoles(Arrays.asList(rol));
        usurepo.save(user);
    }

    public Integer totalPuntos(Usuario usu){
        Integer ejercicios = usu.getPuntosEjercicios();
        Integer respuestas = usu.getPuntosRespuestas();

        if(ejercicios != null && respuestas != null) {
            return ejercicios + respuestas;
        }else if(ejercicios != null) {
            return ejercicios;
        }else if(respuestas != null){
            return respuestas;
        } else{
            return 0;
        }
    }

    @Override
    public List<UsuarioDTO> listaUsus() {
        List<Usuario> usuarios = usurepo.findAll();

        return usuarios.stream()
                .map((user) -> mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    public Optional<Usuario> findById(Long id) {
        return usurepo.findById(id);
    }

    public Usuario findByEmail(String email) {
        return usurepo.findByEmail(email);
    }

    private Rol checkRoleExist(){
        Rol role = new Rol();
        role.setName("ADMIN");
        return roleRepository.save(role);
    }

    private UsuarioDTO mapToUserDTO(Usuario user){
        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setFirstName(user.getNombre());
        userDTO.setLastName(user.getApellidos());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getClave());
        return userDTO;
    }

    @Override
    public void deleteByEmail(String email){
        usurepo.deleteByEmail(email);
    }
}
