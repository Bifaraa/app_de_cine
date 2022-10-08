package com.mintic.cine.controler;

import com.mintic.cine.modelo.Compra;
import com.mintic.cine.services.CompraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/compra")
public class CompraControler {
    @Autowired
    private CompraServices service;

    @PostMapping(value = "/create")
    public ResponseEntity<Compra> create(@RequestBody Compra compra){
        Compra compraNew = service.create(compra);
        return ResponseEntity.status(HttpStatus.OK).body(compraNew);
    }
}
