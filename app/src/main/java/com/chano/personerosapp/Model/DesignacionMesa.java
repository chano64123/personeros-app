package com.chano.personerosapp.Model;

public class DesignacionMesa {
    private  int idDesignacionMesa;
    private  int idUsuario;
    private  int idMesa;
    private  Usuario usuario;
    private  Mesa mesa;

    public DesignacionMesa() {
    }

    public DesignacionMesa(int idDesignacionMesa, int idUsuario, int idMesa, Usuario usuario, Mesa mesa) {
        this.idDesignacionMesa = idDesignacionMesa;
        this.idUsuario = idUsuario;
        this.idMesa = idMesa;
        this.usuario = usuario;
        this.mesa = mesa;
    }

    public int getIdDesignacionMesa() {
        return idDesignacionMesa;
    }

    public void setIdDesignacionMesa(int idDesignacionMesa) {
        this.idDesignacionMesa = idDesignacionMesa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
