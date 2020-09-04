package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduapps.Modelos.Actividad;
import com.example.eduapps.Modelos.GlobalVariables;
import com.example.eduapps.Modelos.SesionClase;

public class NuevaActividadActivity extends AppCompatActivity {

    EditText etTituloActividad, etPropositoActividad, etTiempoActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad);

        // Recibir parametros
        Bundle parametros        = getIntent().getExtras();
        final int sesionId       = parametros.getInt(getResources().getString(R.string.pactsesionid));
        Toast.makeText(getBaseContext(), Integer.toString(sesionId), Toast.LENGTH_LONG).show();

        // Traer los EditText
        etTituloActividad    = (EditText) findViewById(R.id.etTituloActividad);
        etPropositoActividad = (EditText) findViewById(R.id.etPropositoActividad);
        etTiempoActividad    = (EditText) findViewById(R.id.etTiempoActividad);

        // intent de los botones
        Button btnNActAgregar = (Button)findViewById(R.id.btnNActAgregar);
        btnNActAgregar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(NuevaActividadActivity.this, AgregarActividadesActivity.class);
                intent.putExtra(getResources().getString(R.string.pid), sesionId);

                // Agregar nueva sesion
                Actividad actividad;

                String titulo         = etTituloActividad.getText().toString();
                String proposito      = etPropositoActividad.getText().toString();
                String tiempo         = etTiempoActividad.getText().toString();

                actividad = new Actividad(++GlobalVariables.getInstance().actividadesId, sesionId, titulo, proposito, tiempo);
                GlobalVariables.getInstance().actividades.add(actividad);

                startActivity(intent);
                finish();
            }
        });

        Button btnNActVolver = (Button)findViewById(R.id.btnNActVolver);
        btnNActVolver.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(NuevaActividadActivity.this, AgregarActividadesActivity.class);
                intent.putExtra(getResources().getString(R.string.pid), sesionId);

                startActivity(intent);
                finish();
            }
        });
    }
}