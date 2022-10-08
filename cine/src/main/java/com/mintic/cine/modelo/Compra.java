package com.mintic.cine.modelo;

import javax.persistence.*;

@Entity
@Table(name = "COMPRA")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_compra;
    private Integer id_usuario;
    private Integer id_pelicula;
    private Integer id_combo;
    private Integer numero_de_sillas;

    public Compra(){

    }

    public Compra(Integer id_compra, Integer id_usuario, Integer id_pelicula, Integer id_combo, Integer numero_de_sillas) {
        this.id_compra = id_compra;
        this.id_usuario = id_usuario;
        this.id_pelicula = id_pelicula;
        this.id_combo = id_combo;
        this.numero_de_sillas = numero_de_sillas;
    }

    public Compra(Integer id_usuario, Integer id_pelicula, Integer id_combo, Integer numero_de_sillas) {
        this.id_compra = id_compra;
        this.id_usuario = id_usuario;
        this.id_pelicula = id_pelicula;
        this.id_combo = id_combo;
        this.numero_de_sillas = numero_de_sillas;
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public Integer getId_pelicula() {
        return id_pelicula;
    }

    public Integer getId_combo() {
        return id_combo;
    }

    public Integer getNumero_de_sillas() {
        return numero_de_sillas;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public void setId_combo(Integer id_combo) {
        this.id_combo = id_combo;
    }

    public void setNumero_de_sillas(Integer numero_de_sillas) {
        this.numero_de_sillas = numero_de_sillas;
    }
}
