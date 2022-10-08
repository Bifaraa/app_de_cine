package com.mintic.cine.repository;

import com.mintic.cine.modelo.Pelicula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
}
