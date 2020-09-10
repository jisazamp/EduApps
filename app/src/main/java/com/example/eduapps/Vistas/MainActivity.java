package com.example.eduapps.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eduapps.R;

/*
 * Esta es la vista de inicio de la aplicación, donde se le
 * presentan al usuario dos opciones, iniciar sesión o registrarse.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public void procesarEvento(int opc) {
        /*
         * Método que tiene como parámetro un entero, que es el
         * id del botón que quiero usar. No tiene salidas.
         * Inicializa el intent de la opción seleccionada por el usuario.
         */

        Intent intent;

        switch (opc)
        {
            case R.id.loginButton:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.registroButton:
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaracion de botones
        Button btn_login = (Button)findViewById(R.id.loginButton);
        Button btn_registro = (Button)findViewById(R.id.registroButton);

        // set del listener a los botones
        btn_login.setOnClickListener(this);
        btn_registro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        procesarEvento(view.getId());
    }
}