package com.example.eduapps.Vistas;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.eduapps.Modelos.SesionClase;

import java.util.ArrayList;

public interface ITeacherHomeActivityView {

    public ArrayAdapter<String> crearAdaptador(ArrayList<String> nombresSesion);

    public void inicializarAdaptadorLV(ArrayAdapter<String> adapter);

    public void inicializarSesiones();

    public ArrayList<String> inicializarNombres(ArrayList<SesionClase> sesiones);

    public void lstViewListener(ListView lst);

}
