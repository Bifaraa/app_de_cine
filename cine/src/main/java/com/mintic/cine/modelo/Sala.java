package com.mintic.cine.modelo;

import javax.persistence.*;

@Entity
@Table(name = "SALA")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_sala;
    private Integer numero_sillas;

    public Sala(){
    }

    public Sala(Integer id_sala, Integer numero_sillas) {
        this.id_sala = id_sala;
        this.numero_sillas = numero_sillas;
    }

    public Integer getId_sala() {
        return id_sala;
    }

    public Integer getNumero_sillas() {
        return numero_sillas;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public void setNumero_sillas(Integer numero_sillas) {
        this.numero_sillas = numero_sillas;
    }
}
