package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/*
 * Esta es la vista donde están los campos necesarios para registrar
 * una nueva sesión de clase.
 */

public class AgregarSesionActivity extends AppCompatActivity {

    // declaracion de variables
    Spinner spinner, spinner1;
    private static final String TAG = "AgregarSesionActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_sesion);

        // intent de los botones
        Button btn_agregar = (Button)findViewById(R.id.agregarButton);
        btn_agregar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                intent = new Intent(AgregarSesionActivity.this, TeacherHomeActivity.class);
                startActivity(intent);
            }
        });

        Button btn_cancelar = (Button)findViewById(R.id.cancelarButton);
        btn_cancelar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                intent = new Intent(AgregarSesionActivity.this, TeacherHomeActivity.class);
                startActivity(intent);
            }
        });

        // declaracion de los spinner
        spinner = findViewById(R.id.spinner1);
        spinner1 = findViewById(R.id.spinner2);

        // datos "quemados" para popular el spinner
        String[] value = {"Básica", "Media"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.style_spinner, arrayList);
        spinner.setAdapter(arrayAdapter);

        // datos "quemados" para popular el spinner1
        String[] value1 = {"1", "2"};
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(value1));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, R.layout.style_spinner, arrayList1);
        spinner1.setAdapter(arrayAdapter1);

        // inicialización de la variable para seleccionar la fecha de inicio
        // de la sesión de clase
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        // ClickListener que abre una ventana para seleccionar la fecha
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inicializamos la instancia para que muestre la fecha actual
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AgregarSesionActivity.this,
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);

                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                // TO-DO
            }
        };
    }
}