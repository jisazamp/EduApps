package com.example.eduapps.Modelos;

import java.util.ArrayList;

public class GlobalVariables {
    public ArrayList<User> users;
    public ArrayList<SesionClase> sesiones;
    public ArrayList<Actividad> actividades;
    public int sesionesId;
    public int actividadesId;

    /*public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        users.add(user);
    }*/


    private GlobalVariables() {
        users = new ArrayList<User>();
        sesiones = new ArrayList<SesionClase>();
        actividades = new ArrayList<Actividad>();
        sesionesId = 7;
        actividadesId = 0;
    }

    private static GlobalVariables instance;

    public static GlobalVariables getInstance() {
        if (instance == null) instance = new GlobalVariables();
        return instance;
    }
}
