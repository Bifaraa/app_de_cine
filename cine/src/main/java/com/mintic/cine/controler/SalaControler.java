package com.mintic.cine.controler;

import com.mintic.cine.modelo.Sala;
import com.mintic.cine.services.SalaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/sala")
public class SalaControler {
    @Autowired
    private SalaServices service;

    @GetMapping(value ="/list" )
    public ResponseEntity<List<Sala>> listaSalas(){
        List<Sala> list = service.listSala();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
