package com.example.eduapps.Presentador;

import android.content.Context;

import com.example.eduapps.Modelos.SesionClase;
import com.example.eduapps.Vistas.ITeacherHomeActivityView;
import com.example.eduapps.db.ConstructorSesiones;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class TeacherHomeActivityPresenter implements ITeacherHomeActivityPresenter{

    private ITeacherHomeActivityView iTeacherHomeActivityView;
    private Context context;
    private ConstructorSesiones constructorSesiones;
    private ArrayList<String> sesiones;

    public TeacherHomeActivityPresenter(ITeacherHomeActivityView iTeacherHomeActivityView,
                                        Context context) {
        this.iTeacherHomeActivityView = iTeacherHomeActivityView;
        this.context = context;
        obtenerSesionesBaseDatos();
    }

    @Override
    public void obtenerSesionesBaseDatos() {
        constructorSesiones = new ConstructorSesiones(context);
        sesiones = constructorSesiones.obtenerDatos();
        mostrarSesionesLV();
    }

    @Override
    public void mostrarSesionesLV() {
        iTeacherHomeActivityView.inicializarAdaptadorLV(iTeacherHomeActivityView.crearAdaptador(sesiones));
    }
}
