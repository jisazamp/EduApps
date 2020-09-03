package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActividad extends AppCompatActivity {

    private TextView tvTitulo, tvDescripcion, tvArea, tvNivelFormacion, tvDba, tvFechainicio,
                    tvFechaCierre;

    Button btnVolverDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad);

        // Recibir parametros
        Bundle parametros        = getIntent().getExtras();
        String titulo            = parametros.getString(getResources().getString(R.string.ptitulo));
        String descripcion       = parametros.getString(getResources().getString(R.string.pproposito));
        String area              = parametros.getString(getResources().getString(R.string.parea));
        String nivelFormacion    = parametros.getString(getResources().getString(R.string.pnivelformacion));
        String dba               = parametros.getString(getResources().getString(R.string.pdba));
        String fechaInicio       = parametros.getString(getResources().getString(R.string.pfechainicio));
        String fechaCierre       = parametros.getString(getResources().getString(R.string.pfechacierre));

        // Ya capturamos los datos, ahora para mostrarlos
        tvTitulo            = (TextView) findViewById(R.id.tvTitulo);
        tvDescripcion       = (TextView) findViewById(R.id.tvProposito);
        tvArea              = (TextView) findViewById(R.id.tvArea);
        tvNivelFormacion    = (TextView) findViewById(R.id.tvNivelFormacion);
        tvDba               = (TextView) findViewById(R.id.tvDba);
        tvFechainicio       = (TextView) findViewById(R.id.tvFechaInicio);
        tvFechaCierre       = (TextView) findViewById(R.id.tvFechaCierre);

        // Seteamos los TextView
        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);
        tvArea.setText(area);
        tvNivelFormacion.setText(nivelFormacion);
        tvDba.setText(dba);
        tvFechainicio.setText(fechaInicio);
        tvFechaCierre.setText(fechaCierre);

        // Intent para el boton
        btnVolverDetalles = (Button) findViewById(R.id.btnVolverDetalle);
        btnVolverDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleActividad.this, TeacherHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}