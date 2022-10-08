package com.mintic.cine.repository;

import com.mintic.cine.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface userRepository extends  CrudRepository<Usuario, Integer>{
}
