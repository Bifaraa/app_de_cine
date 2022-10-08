package com.mintic.cine.repository;


import com.mintic.cine.modelo.Sala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Integer> {
}
