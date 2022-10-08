package com.mintic.cine.services;

import com.mintic.cine.modelo.Usuario;
import com.mintic.cine.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserServices{
    @Autowired
    private userRepository repo;
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) repo.findAll();
    }

    public Usuario create(Usuario user){
        return repo.save(user);
    }
    public Usuario recibirUsuarios(Map user){
        List<Usuario> list = (List<Usuario>) repo.findAll();
        String correo = user.get("correo").toString();
        String contraseña = user.get("contraseña").toString();
        for( Usuario elemento: list){
            if(elemento.getCorreo().equals(correo) && elemento.getContraseña().equals(contraseña)){
                System.out.println("encontro usuario");
                return elemento;
            }
        }
        return null;
    }
}
