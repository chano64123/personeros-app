package com.chano.personerosapp.Model;

public class Persona {
    private int idPersona;
    private int idDistritoDireccion;
    private int idInstitucionVotacion;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String celular;
    private String direccion;
    private Distrito distritoResidencia;
    private Institucion institucionVotacion;

    public Persona() {
    }

    public Persona(int idPersona, int idDistritoDireccion, int idInstitucionVotacion, String dni, String nombres, String apellidoPaterno, String apellidoMaterno, String celular, String direccion, Distrito distritoResidencia, Institucion institucionVotacion) {
        this.idPersona = idPersona;
        this.idDistritoDireccion = idDistritoDireccion;
        this.idInstitucionVotacion = idInstitucionVotacion;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.celular = celular;
        this.direccion = direccion;
        this.distritoResidencia = distritoResidencia;
        this.institucionVotacion = institucionVotacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdDistritoDireccion() {
        return idDistritoDireccion;
    }

    public void setIdDistritoDireccion(int idDistritoDireccion) {
        this.idDistritoDireccion = idDistritoDireccion;
    }

    public int getIdInstitucionVotacion() {
        return idInstitucionVotacion;
    }

    public void setIdInstitucionVotacion(int idInstitucionVotacion) {
        this.idInstitucionVotacion = idInstitucionVotacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCompleteNames(){
        String complete = getNombres() + " " + getApellidoPaterno();
        complete += getApellidoMaterno() != null ? " " + getApellidoMaterno() : "";
        return complete;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Distrito getDistritoResidencia() {
        return distritoResidencia;
    }

    public void setDistritoResidencia(Distrito distritoResidencia) {
        this.distritoResidencia = distritoResidencia;
    }

    public Institucion getInstitucionVotacion() {
        return institucionVotacion;
    }

    public void setInstitucionVotacion(Institucion institucionVotacion) {
        this.institucionVotacion = institucionVotacion;
    }
}
