package com.mintic.cine.services;

import com.mintic.cine.modelo.Compra;
import com.mintic.cine.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServices {
    @Autowired
    private CompraRepository repo;

    public Compra create(Compra compra){
        return repo.save(compra);
    }

    public List<Compra> listCompra(){
        return (List<Compra>) repo.findAll();
    }
}
