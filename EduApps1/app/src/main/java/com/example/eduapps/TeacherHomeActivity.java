package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherHomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[];
    Button[] b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.sesiones);
        s2 = getResources().getStringArray(R.array.descripcion);

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