package com.example.eduapps.db;

import android.content.Context;

import com.example.eduapps.Modelos.SesionClase;

import java.util.ArrayList;

public class ConstructorSesiones {

    private Context context;

    public ConstructorSesiones(Context context) {
        this.context = context;
    }

    public ArrayList<String> obtenerDatos() {
        ArrayList<SesionClase> sesiones = new ArrayList<>();
        sesiones.add(new SesionClase(1, "Sesion 0", "Descripcion 0", "Area 0"
                ,"NF0", "DBA0", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase(2, "Sesion 1", "Descripcion 1", "Area 1"
                ,"NF1", "DBA1", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase(3, "Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));

        ArrayList<String> nombres = new ArrayList<>();
        for (SesionClase sesion : sesiones) {
            nombres.add(sesion.getTitulo());
        }

        return nombres;

    }

}
