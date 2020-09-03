package com.example.eduapps.Modelos;

import android.app.Application;

public class SesionClase extends Application {

    // Atributos
    private int Id;
    private String titulo;
    private String descripcion;
    private String area;
    private String nivelFormacion;
    private String DBA;
    private String fechaInicio;
    private String fechaCierre;

    // Constructor
    public SesionClase(int Id, String titulo, String descripcion, String area, String nivelFormacion,
                       String DBA, String fechaInicio, String fechaCierre) {
        this.Id = Id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.area = area;
        this.nivelFormacion = nivelFormacion;
        this.DBA = DBA;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
    }

    // Accesores


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }

    public String getDBA() {
        return DBA;
    }

    public void setDBA(String DBA) {
        this.DBA = DBA;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
