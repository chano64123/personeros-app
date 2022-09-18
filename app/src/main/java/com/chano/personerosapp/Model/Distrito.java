package com.chano.personerosapp.Model;

public class Distrito {
    private int idDistrito;
    private String nombre;

    public Distrito() {
    }

    public Distrito(int idDistrito, String nombre) {
        this.idDistrito = idDistrito;
        this.nombre = nombre;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
