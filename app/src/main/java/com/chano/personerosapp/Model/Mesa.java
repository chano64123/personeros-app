package com.chano.personerosapp.Model;

public class Mesa {
    private int idMesa;
    private int idInstitucion;
    private String aula;
    private String numero;
    private int cantidadElectores;
    private Institucion institucion;

    public Mesa() {
    }

    public Mesa(int idMesa, int idInstitucion, String aula, String numero, int cantidadElectores, Institucion institucion) {
        this.idMesa = idMesa;
        this.idInstitucion = idInstitucion;
        this.aula = aula;
        this.numero = numero;
        this.cantidadElectores = cantidadElectores;
        this.institucion = institucion;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCantidadElectores() {
        return cantidadElectores;
    }

    public void setCantidadElectores(int cantidadElectores) {
        this.cantidadElectores = cantidadElectores;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
