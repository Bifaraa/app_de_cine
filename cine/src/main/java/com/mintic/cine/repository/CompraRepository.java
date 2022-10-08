package com.mintic.cine.repository;


import com.mintic.cine.modelo.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Integer> {
}
