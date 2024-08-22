package com.rojo.ClinicaOdontologia.model;

import com.rojo.ClinicaOdontologia.utils.GsonProvider;

public class Odontologo {
    private Integer id;
    private Integer numeroMatricula;
    private String Nombre;
    private String Apellido;

    public Odontologo() {
    }

    public Odontologo(Integer id, Integer numeroMatricula, String nombre, String apellido) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Odontologo(Integer numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
