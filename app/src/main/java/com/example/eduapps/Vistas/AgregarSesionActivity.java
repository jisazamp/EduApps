package com.example.eduapps.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eduapps.Modelos.GlobalVariables;
import com.example.eduapps.Modelos.SesionClase;
import com.example.eduapps.R;

import java.util.Calendar;

/*
 * Esta es la vista donde están los campos necesarios para registrar
 * una nueva sesión de clase.
 */

public class AgregarSesionActivity extends AppCompatActivity {

    // declaracion de variables
    DatePickerDialog picker;
    Intent intent;
    TextView tiFechaInicio, etFechaCierre;
    EditText etTitulo, etProposito, etDba, etArea, etNivelFormacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_sesion);

        // Intent boton cancelar
        Button btn_cancelar = (Button)findViewById(R.id.cancelarButton);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                intent = new Intent(AgregarSesionActivity.this, TeacherHomeActivity.class);
                startActivity(intent);
            }
        });

        // Picker para la fecha de inicio
        tiFechaInicio = (TextView) findViewById(R.id.tiFechaInicio);
        tiFechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // picker
                picker = new DatePickerDialog(AgregarSesionActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tiFechaInicio.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        // Picker para la fecha de cierre
        etFechaCierre = (TextView) findViewById(R.id.etFechaCierre);
        etFechaCierre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // picker
                picker = new DatePickerDialog(AgregarSesionActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etFechaCierre.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        // Traer los EditText
        etTitulo         = (EditText) findViewById(R.id.etTitulo);
        etProposito      = (EditText) findViewById(R.id.etProposito);
        etDba            = (EditText) findViewById(R.id.etDba);
        etArea           = (EditText) findViewById(R.id.etArea);
        etNivelFormacion = (EditText) findViewById(R.id.etNivelFormacion);

        // intent de los botones
        Button btn_agregar = (Button)findViewById(R.id.agregarButton);
        btn_agregar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                intent = new Intent(AgregarSesionActivity.this, TeacherHomeActivity.class);

                // Agregar nueva sesion
                SesionClase nuevaSesion;

                String titulo         = etTitulo.getText().toString();
                String proposito      = etProposito.getText().toString();
                String dba            = etDba.getText().toString();
                String area           = etArea.getText().toString();
                String nivelFormacion = etNivelFormacion.getText().toString();

                nuevaSesion = new SesionClase(++GlobalVariables.getInstance().sesionesId, titulo, proposito, dba, area, nivelFormacion
                            , tiFechaInicio.getText().toString(), etFechaCierre.getText().toString());
                GlobalVariables.getInstance().sesiones.add(nuevaSesion);

                startActivity(intent);
                finish();
            }
        });
    }
}