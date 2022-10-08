package com.mintic.cine.services;

import com.mintic.cine.modelo.Comida;
import com.mintic.cine.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComidaServices {
    @Autowired
    private ComidaRepository repo;

    public List<Comida> listComida(){
        return (List<Comida>) repo.findAll();
    }

    public Integer buscarId(String nombre){
        String nombreBuscar = nombre.replaceAll("\"", "");
        List<Comida> list = (List<Comida>) repo.findAll();
        Integer id_comida = 0;
        for(Comida comida: list){
            if(comida.getNombre().equalsIgnoreCase(nombreBuscar)){
                id_comida = comida.getId_combo();
            }
        }
        return id_comida;
    }
}
