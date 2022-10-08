package com.mintic.cine.controler;

import com.mintic.cine.modelo.Comida;
import com.mintic.cine.services.ComidaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/comida")
public class ComidaControler {
    @Autowired
    private ComidaServices service;

    @GetMapping(value ="/list" )
    public ResponseEntity<List<Comida>> listaComida(){
        List<Comida> list = service.listComida();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping(value ="/id")
    public ResponseEntity<Integer> busqueId(@RequestBody String nombreCombo){
        Integer comboID = service.buscarId(nombreCombo);
        return ResponseEntity.status(HttpStatus.OK).body(comboID);
    }
}
