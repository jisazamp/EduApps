package com.example.eduapps.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eduapps.Modelos.Actividad;
import com.example.eduapps.Modelos.GlobalVariables;
import com.example.eduapps.R;

import java.util.ArrayList;

public class AgregarActividadesActivity extends AppCompatActivity {

    // Variables globales
    ArrayList<Actividad> actividades;
    int actividadesCount = 0;
    int sesionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividades);

        // Recibir parametros
        Bundle parametros        = getIntent().getExtras();
        sesionId       = parametros.getInt(getResources().getString(R.string.pid));
        Toast.makeText(getBaseContext(), Integer.toString(sesionId), Toast.LENGTH_LONG).show();

        // Inicializar sesiones
        if (GlobalVariables.getInstance().actividades.size() == 0) {
            //fillActividades();
            actividades = GlobalVariables.getInstance().actividades;
        } else {
            actividades = GlobalVariables.getInstance().actividades;
        }

        // Traemos los nombres
        ArrayList<String> nombreActividad = new ArrayList<>();
        for (Actividad actividad : GlobalVariables.getInstance().actividades) {
            if (actividad.getSesionId() == sesionId) {
                nombreActividad.add(actividad.getTitulo());
            }
        }

        // Inicializamos ListView
        ListView lstActividades = (ListView) findViewById(R.id.lstActividades);
        lstActividades.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreActividad));

        // Intent explicito
        lstActividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AgregarActividadesActivity.this, DetalleActividadesActivity.class);
                intent.putExtra(getResources().getString(R.string.pactid), actividades.get(i).getId());
                intent.putExtra(getResources().getString(R.string.pactsesionid), actividades.get(i).getSesionId());
                intent.putExtra(getResources().getString(R.string.pactnombre), actividades.get(i).getTitulo());
                intent.putExtra(getResources().getString(R.string.pactproposito), actividades.get(i).getProposito());
                intent.putExtra(getResources().getString(R.string.pacttiempo), actividades.get(i).getTiempo());

                startActivity(intent);
            }
        });

        // intent para el boton de registrar sesion
        Button btnAgregarActividad = (Button)findViewById(R.id.btnAgregarActividad);
        btnAgregarActividad.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(AgregarActividadesActivity.this, NuevaActividadActivity.class);
                intent.putExtra(getResources().getString(R.string.pactsesionid), sesionId);
                startActivity(intent);
                finish();
            }
        });
    }

//    public void fillActividades() {
//        for (int i = 0; i < 4; i++) {
//            Actividad actividad = new Actividad(actividadesCount, 1
//                    , "Dummy", "Dummy purpose", "25mins");
//            actividadesCount++;
//
//            GlobalVariables.getInstance().actividades.add(actividad);
//        }
//    }
}