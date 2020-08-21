package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Esta es la vista para registro del usuario.
 * Después de ingresar los datos de registro y presionar el botón de
 * "Registrar" lleva el usuario a una pantalla de Splash confirmando
 * su registro y luego llevándolo al Home.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn_registrar = (Button)findViewById(R.id.registrarButton);
        btn_registrar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(RegisterActivity.this, SplashRegister.class);
                startActivity(intent);
                finish();
            }
        });
    }
}