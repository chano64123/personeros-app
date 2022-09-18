package com.chano.personerosapp.Model;

import android.app.Person;

import com.chano.personerosapp.API.API;
import com.chano.personerosapp.App.Config;
import com.chano.personerosapp.Service.IUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class Usuario {
    private int idUsuario;
    private int idTipoUsuario;
    private int idPersona;
    private String nombreUsuario;
    private int cantidadMaximaMesas;
    private int cantidadMaximaInstituciones;
    private TipoUsuario tipoUsuario;
    private Persona persona;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idTipoUsuario, int idPersona, String nombreUsuario, int cantidadMaximaMesas, int cantidadMaximaInstituciones, TipoUsuario tipoUsuario, Persona persona) {
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.idPersona = idPersona;
        this.nombreUsuario = nombreUsuario;
        this.cantidadMaximaMesas = cantidadMaximaMesas;
        this.cantidadMaximaInstituciones = cantidadMaximaInstituciones;
        this.tipoUsuario = tipoUsuario;
        this.persona = persona;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getCantidadMaximaMesas() {
        return cantidadMaximaMesas;
    }

    public void setCantidadMaximaMesas(int cantidadMaximaMesas) {
        this.cantidadMaximaMesas = cantidadMaximaMesas;
    }

    public int getCantidadMaximaInstituciones() {
        return cantidadMaximaInstituciones;
    }

    public void setCantidadMaximaInstituciones(int cantidadMaximaInstituciones) {
        this.cantidadMaximaInstituciones = cantidadMaximaInstituciones;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Call<Response<Usuario>> getUserById(int idUsuario){
        Retrofit retrofit = API.getRetrofitClient(Config.BASE_URL_API_PERSONEROS);
        IUsuario api = retrofit.create(IUsuario.class);
        return api.getUserById(idUsuario);
    }

    public Call<Response<Usuario>> loginUser(Login login){
        Retrofit retrofit = API.getRetrofitClient(Config.BASE_URL_API_PERSONEROS);
        IUsuario api = retrofit.create(IUsuario.class);
        return api.loginUser(login);
    }
}
