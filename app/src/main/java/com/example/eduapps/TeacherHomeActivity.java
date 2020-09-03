package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eduapps.Modelos.SesionClase;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

/*
 * Este es el Home de la aplicación, donde el profesor puede consultar
 * sus sesiones de clase creadas y publicadas. Al igual que navegar a las vistas
 * para asignar actividades a estas sesiones.
 */

public class TeacherHomeActivity extends AppCompatActivity {

    // Variables globales
    ArrayList<SesionClase> sesiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        // Inicializar sesiones
        sesiones = new ArrayList<SesionClase>();
        sesiones = fillArray(sesiones);

        // Traemos los nombres
        ArrayList<String> nombresSesion = new ArrayList<>();
        for (SesionClase sesion : sesiones) {
            nombresSesion.add(sesion.getTitulo());
        }

        // Inicializamos ListView
        ListView lstSesiones = (ListView) findViewById(R.id.lstSesiones);
        lstSesiones.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresSesion));

        // Intent explicito
        lstSesiones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TeacherHomeActivity.this, DetalleActividad.class);
                intent.putExtra(getResources().getString(R.string.ptitulo), sesiones.get(i).getTitulo());
                intent.putExtra(getResources().getString(R.string.pproposito), sesiones.get(i).getDescripcion());
                intent.putExtra(getResources().getString(R.string.parea), sesiones.get(i).getArea());
                intent.putExtra(getResources().getString(R.string.pnivelformacion), sesiones.get(i).getNivelFormacion());
                intent.putExtra(getResources().getString(R.string.pdba), sesiones.get(i).getDBA());
                intent.putExtra(getResources().getString(R.string.pfechainicio), sesiones.get(i).getFechaInicio());
                intent.putExtra(getResources().getString(R.string.pfechacierre), sesiones.get(i).getFechaCierre());
                startActivity(intent);
            }
        });

        // Bundler para recibir el intent
        Bundle parametros = getIntent().getExtras();
        String usuario_logueado = parametros.getString(getResources().getString(R.string.pnombre));

        Toast.makeText(getBaseContext(), usuario_logueado, Toast.LENGTH_LONG).show();

        // intent para el boton de registrar sesion
        Button btn_registrar_sesion = (Button)findViewById(R.id.agregarSesionButton);
        btn_registrar_sesion.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(TeacherHomeActivity.this, AgregarSesionActivity.class);
                startActivity(intent);
            }
        });
    }

    public ArrayList<SesionClase> fillArray(ArrayList<SesionClase> sesiones) {
        sesiones.add(new SesionClase("Sesion 1", "Descripcion 1", "Area 1"
                ,"NF1", "DBA1", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 1", "Descripcion 1", "Area 1"
                ,"NF1", "DBA1", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));
        sesiones.add(new SesionClase("Sesion 2", "Descripcion 2", "Area 2"
                ,"NF2", "DBA2", "02/10/1996"
                ,"02/10/1996"));

        return sesiones;
    }
}