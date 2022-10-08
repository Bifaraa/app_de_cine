package com.mintic.cine.modelo;

import javax.persistence.*;

@Entity
@Table(name = "comida")
public class Comida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_combo;
    private String url_img;
    private Double precio;
    private String descripcion;

    private String nombre;

    Comida(){
    }

    public Comida(Integer id_combo, String url_img, Double precio, String descripcion, String nombre) {
        this.id_combo = id_combo;
        this.url_img = url_img;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getId_combo() {
        return id_combo;
    }

    public String getUrl_img() {
        return url_img;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId_combo(Integer id_combo) {
        this.id_combo = id_combo;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
