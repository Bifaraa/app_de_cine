package com.mintic.cine.modelo;

import javax.persistence.*;

@Entity
@Table(name = "PELICULA")
public class Pelicula {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_pelicula;
    private int id_sala;
    private String genero;
    private String duracion;
    private int año;
    private String descripcion;
    private String url_poster;

    private String estado_pelicula;

    private String nombre;

    public Pelicula() {
    }

    public Pelicula(Integer id_pelicula, int id_sala, String genero, String duracion, int año, String descripcion, String url_poster, String estado_pelicula, String nombre) {
        this.id_pelicula = id_pelicula;
        this.id_sala = id_sala;
        this.genero = genero;
        this.duracion = duracion;
        this.año = año;
        this.descripcion = descripcion;
        this.url_poster = url_poster;
        this.estado_pelicula = estado_pelicula;
        this.nombre = nombre;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public int getId_sala() {
        return id_sala;
    }

    public String getGenero() {
        return genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getAño() {
        return año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl_poster() {
        return url_poster;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl_poster(String url_poster) {
        this.url_poster = url_poster;
    }

    public String getEstado_pelicula() {
        return estado_pelicula;
    }

    public void setEstado_pelicula(String estado_pelicula) {
        this.estado_pelicula = estado_pelicula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
