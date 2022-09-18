package com.chano.personerosapp.Model;

public class Institucion {
    private int idInstitucion;
    private int idDistrito;
    private String nombre;
    private String direccion;
    private int cantidadMesas;
    private int cantidadElectores;
    private Distrito distrito;

    public Institucion() {
    }

    public Institucion(int idInstitucion, int idDistrito, String nombre, String direccion, int cantidadMesas, int cantidadElectores, Distrito distrito) {
        this.idInstitucion = idInstitucion;
        this.idDistrito = idDistrito;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadMesas = cantidadMesas;
        this.cantidadElectores = cantidadElectores;
        this.distrito = distrito;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidadMesas() {
        return cantidadMesas;
    }

    public void setCantidadMesas(int cantidadMesas) {
        this.cantidadMesas = cantidadMesas;
    }

    public int getCantidadElectores() {
        return cantidadElectores;
    }

    public void setCantidadElectores(int cantidadElectores) {
        this.cantidadElectores = cantidadElectores;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
