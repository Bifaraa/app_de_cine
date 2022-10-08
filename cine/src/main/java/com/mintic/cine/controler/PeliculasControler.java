package com.mintic.cine.controler;

import com.mintic.cine.modelo.Pelicula;
import com.mintic.cine.modelo.Sala;
import com.mintic.cine.services.PeliculaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "api/peliculas")

public class PeliculasControler {
    @Autowired
    private PeliculaServices service;

    @GetMapping(value ="/list" )
    public ResponseEntity<List<Pelicula>> listaPeliculas(){
        List<Pelicula> list = service.listPelicula();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping(value ="/sala")
    public ResponseEntity<Sala> busqueSala(@RequestBody String nombrePelicula){
        Sala salaBuscada = service.buscarSala(nombrePelicula);
        return ResponseEntity.status(HttpStatus.OK).body(salaBuscada);
    }

    @PostMapping(value ="/id_pelicula")
    public ResponseEntity<Integer> busqueId(@RequestBody String nombrePelicula){
        Integer peliculaID = service.buscarId(nombrePelicula);
        return ResponseEntity.status(HttpStatus.OK).body(peliculaID);
    }
}
