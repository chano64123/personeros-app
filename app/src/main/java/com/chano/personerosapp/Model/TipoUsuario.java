package com.chano.personerosapp.Model;

public class TipoUsuario {
    private int idTipoUsuario;
    private String nombre;
    private int identificador;
    private int nivelAcceso;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipoUsuario, String nombre, int identificador, int nivelAcceso) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
        this.identificador = identificador;
        this.nivelAcceso = nivelAcceso;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}
