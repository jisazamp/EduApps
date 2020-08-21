package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Este es el Home de la aplicación, donde el profesor puede consultar
 * sus sesiones de clase creadas y publicadas. Al igual que navegar a las vistas
 * para asignar actividades a estas sesiones.
 */

public class TeacherHomeActivity extends AppCompatActivity {

    // declaracion variables
    RecyclerView recyclerView;
    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        // inicializamos recyclerView
        // y traemos los arreglos de strings que estan en strings.xlm
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.sesiones);
        s2 = getResources().getStringArray(R.array.descripcion);

        // inicializamos el adaptador que usamos para popular el recyclerView
        MyAdapter myAdapter = new MyAdapter(this, s1, s2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // intent para el boton de registrar sesion
        Button btn_registrar_sesion = (Button)findViewById(R.id.agregarSesionButton);
        btn_registrar_sesion.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(TeacherHomeActivity.this, AgregarSesionActivity.class);
                intent.putExtra("valor", "hola");
                startActivity(intent);
            }
        });
    }
}