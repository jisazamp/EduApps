package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActividadesActivity extends AppCompatActivity {

    TextView tvActividadId, tvActividadSesionId, tvActividadTitulo, tvActividadProposito,
             tvActividadTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividades);

        // Recibir parametros
        Bundle parametros         = getIntent().getExtras();
        if (parametros != null) {
            int actividadId           = parametros.getInt(getResources().getString((R.string.pactid)));
            int sesionId              = parametros.getInt(getResources().getString(R.string.pactsesionid));
            String actividadTitulo    = parametros.getString(getResources().getString(R.string.pactnombre));
            String actividadProposito = parametros.getString(getResources().getString(R.string.pactproposito));
            String actividadTiempo    = parametros.getString(getResources().getString(R.string.pacttiempo));


            // iniciamos los textview
            tvActividadId           = (TextView) findViewById(R.id.tvActividadId);
            tvActividadSesionId     = (TextView) findViewById(R.id.tvActividadSesionId);
            tvActividadTitulo       = (TextView) findViewById(R.id.tvActividadTitulo);
            tvActividadProposito    = (TextView) findViewById(R.id.tvActividadProposito);
            tvActividadTiempo       = (TextView) findViewById(R.id.tvActividadTiempo);

            // seteamos los textview
            tvActividadId.setText(Integer.toString(actividadId));
            tvActividadSesionId.setText(Integer.toString(sesionId));
            tvActividadTitulo.setText(actividadTitulo);
            tvActividadProposito.setText(actividadProposito);
            tvActividadTiempo.setText(actividadTiempo);
        }
    }
}