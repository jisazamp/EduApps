package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

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