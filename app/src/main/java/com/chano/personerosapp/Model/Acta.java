package com.chano.personerosapp.Model;

public class Acta {
    private int idActa;
    private int idMesa;
    private int idTipoEleccion;
    private String foto;
    private int cantidadVotosNulos;
    private int cantidadVotosBlancos;
    private int cantidadVotosImpugnados;
    private int cantidadVotosFavor;
    private int cantidadVotosContra;
    private Mesa mesa;
    private TipoEleccion tipoEleccion;

    public Acta() {
    }

    public Acta(int idActa, int idMesa, int idTipoEleccion, String foto, int cantidadVotosNulos, int cantidadVotosBlancos, int cantidadVotosImpugnados, int cantidadVotosFavor, int cantidadVotosContra, Mesa mesa, TipoEleccion tipoEleccion) {
        this.idActa = idActa;
        this.idMesa = idMesa;
        this.idTipoEleccion = idTipoEleccion;
        this.foto = foto;
        this.cantidadVotosNulos = cantidadVotosNulos;
        this.cantidadVotosBlancos = cantidadVotosBlancos;
        this.cantidadVotosImpugnados = cantidadVotosImpugnados;
        this.cantidadVotosFavor = cantidadVotosFavor;
        this.cantidadVotosContra = cantidadVotosContra;
        this.mesa = mesa;
        this.tipoEleccion = tipoEleccion;
    }

    public int getIdActa() {
        return idActa;
    }

    public void setIdActa(int idActa) {
        this.idActa = idActa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdTipoEleccion() {
        return idTipoEleccion;
    }

    public void setIdTipoEleccion(int idTipoEleccion) {
        this.idTipoEleccion = idTipoEleccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCantidadVotosNulos() {
        return cantidadVotosNulos;
    }

    public void setCantidadVotosNulos(int cantidadVotosNulos) {
        this.cantidadVotosNulos = cantidadVotosNulos;
    }

    public int getCantidadVotosBlancos() {
        return cantidadVotosBlancos;
    }

    public void setCantidadVotosBlancos(int cantidadVotosBlancos) {
        this.cantidadVotosBlancos = cantidadVotosBlancos;
    }

    public int getCantidadVotosImpugnados() {
        return cantidadVotosImpugnados;
    }

    public void setCantidadVotosImpugnados(int cantidadVotosImpugnados) {
        this.cantidadVotosImpugnados = cantidadVotosImpugnados;
    }

    public int getCantidadVotosFavor() {
        return cantidadVotosFavor;
    }

    public void setCantidadVotosFavor(int cantidadVotosFavor) {
        this.cantidadVotosFavor = cantidadVotosFavor;
    }

    public int getCantidadVotosContra() {
        return cantidadVotosContra;
    }

    public void setCantidadVotosContra(int cantidadVotosContra) {
        this.cantidadVotosContra = cantidadVotosContra;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public TipoEleccion getTipoEleccion() {
        return tipoEleccion;
    }

    public void setTipoEleccion(TipoEleccion tipoEleccion) {
        this.tipoEleccion = tipoEleccion;
    }
}
