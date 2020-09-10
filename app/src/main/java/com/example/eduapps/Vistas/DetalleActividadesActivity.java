package com.example.eduapps.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eduapps.Modelos.Actividad;
import com.example.eduapps.Modelos.GlobalVariables;
import com.example.eduapps.R;

public class DetalleActividadesActivity extends AppCompatActivity {

    TextView tvActividadId, tvActividadSesionId, tvActividadTitulo, tvActividadProposito,
             tvActividadTiempo;
    Actividad act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividades);

        // Recibir parametros
        Bundle parametros         = getIntent().getExtras();
        if (parametros != null) {
            int actividadId           = parametros.getInt(getResources().getString((R.string.pactid)));
            final int sesionId              = parametros.getInt(getResources().getString(R.string.pactsesionid));
            String actividadTitulo    = parametros.getString(getResources().getString(R.string.pactnombre));
            String actividadProposito = parametros.getString(getResources().getString(R.string.pactproposito));
            String actividadTiempo    = parametros.getString(getResources().getString(R.string.pacttiempo));

            // buscamos la actividad
            for (Actividad actividad : GlobalVariables.getInstance().actividades) {
                if (actividad.getSesionId() == sesionId) {
                    act = actividad;
                }
            }

            // iniciamos los textview
            tvActividadId           = (TextView) findViewById(R.id.tvActividadId);
            tvActividadSesionId     = (TextView) findViewById(R.id.tvActividadSesionId);
            tvActividadTitulo       = (TextView) findViewById(R.id.tvActividadTitulo);
            tvActividadProposito    = (TextView) findViewById(R.id.tvActividadProposito);
            tvActividadTiempo       = (TextView) findViewById(R.id.tvActividadTiempo);

            // seteamos los textview
            tvActividadId.setText("ID: " + Integer.toString(act.getId()));
            tvActividadSesionId.setText("ID Sesión: " + Integer.toString(act.getSesionId()));
            tvActividadTitulo.setText("Titulo: " + act.getTitulo());
            tvActividadProposito.setText("Propósito: " + act.getProposito());
            tvActividadTiempo.setText("Tiempo: " + act.getTiempo());


            Button btnVolverActividadesDetalle = (Button) findViewById(R.id.btnVolverActividadesDetalle);
            btnVolverActividadesDetalle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DetalleActividadesActivity.this, AgregarActividadesActivity.class);
                    intent.putExtra(getResources().getString(R.string.pactsesionid), sesionId);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}