package com.mintic.cine.repository;

import com.mintic.cine.modelo.Comida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends CrudRepository<Comida, Integer> {
}
