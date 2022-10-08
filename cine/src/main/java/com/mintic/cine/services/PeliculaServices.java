package com.mintic.cine.services;

import com.mintic.cine.modelo.Pelicula;
import com.mintic.cine.modelo.Sala;
import com.mintic.cine.services.SalaServices;
import com.mintic.cine.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServices {
    @Autowired
    private PeliculaRepository repo;
    @Autowired
    private SalaServices servicesSala;
    public Pelicula create(Pelicula pelicula){
        return repo.save(pelicula);
    }
    public List<Pelicula> listPelicula(){
        return (List<Pelicula>) repo.findAll();
    }

    public Sala buscarSala(String nombre){
        String nombreBuscar = nombre.replaceAll("\"", "");
        List<Pelicula> listPeliculas = listPelicula();
        List<Sala> listSalas = servicesSala.listSala();
        Integer  id_sala = 1;
        Sala salaBuscada = null;
        for( Pelicula pelicula: listPeliculas){
            if(pelicula.getNombre().equals(nombreBuscar)){
                id_sala = pelicula.getId_sala();
                break;
            }
        }
        for (Sala sala: listSalas){
            if(sala.getId_sala() == id_sala){
                System.out.println("la sala encontrada es"+sala.getId_sala());
                salaBuscada = sala;
                break;
            }
        }
        return salaBuscada;
    }

    public Integer buscarId(String nombre){
        String nombreBuscar = nombre.replaceAll("\"", "");
        List<Pelicula> list = (List<Pelicula>) repo.findAll();
        Integer id_pelicula = 0;
        for(Pelicula pelicula: list){
            if(pelicula.getNombre().equalsIgnoreCase(nombreBuscar)){
                id_pelicula = pelicula.getId_pelicula();
            }
        }
        return id_pelicula;
    }
}
