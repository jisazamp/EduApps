package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalleActividad extends AppCompatActivity {

    private TextView tvId, tvTitulo, tvDescripcion, tvArea, tvNivelFormacion, tvDba, tvFechainicio,
                    tvFechaCierre;

    Button btnVolverDetalles;
    Button btnAgregarActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad);

        // Recibir parametros
        Bundle parametros        = getIntent().getExtras();
        final int id             = parametros.getInt(getResources().getString(R.string.pid));
        String titulo            = parametros.getString(getResources().getString(R.string.ptitulo));
        String descripcion       = parametros.getString(getResources().getString(R.string.pproposito));
        String area              = parametros.getString(getResources().getString(R.string.parea));
        String nivelFormacion    = parametros.getString(getResources().getString(R.string.pnivelformacion));
        String dba               = parametros.getString(getResources().getString(R.string.pdba));
        String fechaInicio       = parametros.getString(getResources().getString(R.string.pfechainicio));
        String fechaCierre       = parametros.getString(getResources().getString(R.string.pfechacierre));

        // Ya capturamos los datos, ahora para mostrarlos
        tvId                = (TextView) findViewById(R.id.tvId);
        tvTitulo            = (TextView) findViewById(R.id.tvTitulo);
        tvDescripcion       = (TextView) findViewById(R.id.tvProposito);
        tvArea              = (TextView) findViewById(R.id.tvArea);
        tvNivelFormacion    = (TextView) findViewById(R.id.tvNivelFormacion);
        tvDba               = (TextView) findViewById(R.id.tvDba);
        tvFechainicio       = (TextView) findViewById(R.id.tvFechaInicio);
        tvFechaCierre       = (TextView) findViewById(R.id.tvFechaCierre);

        // Seteamos los TextView
        tvId.setText("ID: " + Integer.toString(id));
        tvTitulo.setText("Titulo: " + titulo);
        tvDescripcion.setText("Descripción: " + descripcion);
        tvArea.setText("Área: " + area);
        tvNivelFormacion.setText("Nivel formación: " + nivelFormacion);
        tvDba.setText("DBA: " + dba);
        tvFechainicio.setText("Fecha inicio: " + fechaInicio);
        tvFechaCierre.setText("Fecha cierre: " + fechaCierre);

        // Intent para el boton
        btnVolverDetalles = (Button) findViewById(R.id.btnVolverDetalle);
        btnVolverDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleActividad.this, TeacherHomeActivity.class);
                startActivity(intent);
            }
        });

        btnAgregarActividad = (Button) findViewById(R.id.btnAgregarActividad);
        btnAgregarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleActividad.this, AgregarActividadesActivity.class);
                intent.putExtra(getResources().getString(R.string.pid), id);
                startActivity(intent);
                finish();
            }
        });
    }
}