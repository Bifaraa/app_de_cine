package com.mintic.cine.modelo;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name = "id_usuario")
    private Integer id_usuario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "celular")
    private String celular;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "tipo_de_usuario")
    private String tipo_de_usuario;

    @Column(name= "puntos")
    private int puntos;
    public Usuario() {
    }

    public Usuario(int id_usuario, String correo, String nombre, String apellido, String celular, String contraseña, String tipo_de_usuario, int puntos) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.contraseña = contraseña;
        this.tipo_de_usuario = tipo_de_usuario;
        this.puntos = puntos;
    }

    public Usuario(String correo, String nombre, String apellido, String celular, String contraseña, String tipo_de_usuario, int puntos) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.contraseña = contraseña;
        this.tipo_de_usuario = tipo_de_usuario;
        this.puntos = puntos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTipo_de_usuario(String tipo_de_usuario) {
        this.tipo_de_usuario = tipo_de_usuario;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTipo_de_usuario() {
        return tipo_de_usuario;
    }

    public int getId() {
        return id_usuario;
    }

    public int getPuntos() {
        return puntos;
    }
}
