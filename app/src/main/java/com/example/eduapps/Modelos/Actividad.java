package com.example.eduapps.Modelos;

public class Actividad {
    // Atributos
    private int id;
    private int sesionId;
    private String titulo;
    private String proposito;
    private String tiempo;

    // Constructor
    public Actividad(int id, int sesionId, String titulo, String proposito, String tiempo) {
        this.id = id;
        this.sesionId = sesionId;
        this.titulo = titulo;
        this.proposito = proposito;
        this.tiempo = tiempo;
    }

    // Accesores

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSesionId() {
        return sesionId;
    }

    public void setSesionId(int sesionId) {
        this.sesionId = sesionId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
