package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Esta es la vista para inicio de sesión del usuario.
 * Luego de ingresar las credenciales y presionar el botón de "iniciar
 * sesión", lleva al Home de la aplicación.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_iniciar_sesion = (Button)findViewById(R.id.iniciarSesionButton);
        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(LoginActivity.this, TeacherHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}