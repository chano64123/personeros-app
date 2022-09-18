package com.chano.personerosapp.Model;

import android.app.Person;

public class TipoEleccion {
    private int idTipoEleccion;
    private int idPersonaCandidato;
    private int nombre;
    private Person personaCandidato;

    public TipoEleccion() {
    }

    public TipoEleccion(int idTipoEleccion, int idPersonaCandidato, int nombre, Person personaCandidato) {
        this.idTipoEleccion = idTipoEleccion;
        this.idPersonaCandidato = idPersonaCandidato;
        this.nombre = nombre;
        this.personaCandidato = personaCandidato;
    }

    public int getIdTipoEleccion() {
        return idTipoEleccion;
    }

    public void setIdTipoEleccion(int idTipoEleccion) {
        this.idTipoEleccion = idTipoEleccion;
    }

    public int getIdPersonaCandidato() {
        return idPersonaCandidato;
    }

    public void setIdPersonaCandidato(int idPersonaCandidato) {
        this.idPersonaCandidato = idPersonaCandidato;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Person getPersonaCandidato() {
        return personaCandidato;
    }

    public void setPersonaCandidato(Person personaCandidato) {
        this.personaCandidato = personaCandidato;
    }
}
