package com.example.eduapps.Modelos;

import java.util.ArrayList;

public class GlobalVariables {
    public ArrayList<User> users;
    public ArrayList<SesionClase> sesiones;

    /*public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        users.add(user);
    }*/


    private GlobalVariables() {
        users = new ArrayList<User>();
        sesiones = new ArrayList<SesionClase>();
    }

    private static GlobalVariables instance;

    public static GlobalVariables getInstance() {
        if (instance == null) instance = new GlobalVariables();
        return instance;
    }
}
