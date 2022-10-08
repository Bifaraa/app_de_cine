package com.mintic.cine.controler;

import com.mintic.cine.modelo.Pelicula;
import com.mintic.cine.modelo.Usuario;
import com.mintic.cine.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "api/user")

public class UserControler{

    @Autowired
    private UserServices service;

    @GetMapping(value ="/list" )
    public ResponseEntity<List<Usuario>> listaPeliculas(){
        List<Usuario> list = service.listaUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping(value = "/recibir")
    public ResponseEntity<Usuario> recibir(@RequestBody Map user){
        Usuario usuario = service.recibirUsuarios(user);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario user){
        Usuario usuarioCreado = service.create(user);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioCreado);
    }

}
