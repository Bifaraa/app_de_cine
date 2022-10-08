package com.mintic.cine.services;

import com.mintic.cine.modelo.Sala;
import com.mintic.cine.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaServices {
    @Autowired
    private SalaRepository repo;

    public List<Sala> listSala() {
        return (List<Sala>) repo.findAll();
    }
}
