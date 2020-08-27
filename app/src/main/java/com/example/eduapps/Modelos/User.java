package com.example.eduapps.Modelos;

import android.app.Application;

import java.util.ArrayList;

public class User extends Application {
    // atributos
    private String username;
    private String password;

    // constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // accesores
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
