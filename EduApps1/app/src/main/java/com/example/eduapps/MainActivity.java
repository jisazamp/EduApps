package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public void procesarEvento(int opc) {

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

        /*
        btn_login.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("valor", "hola");
                startActivity(intent);
            }
        });

        btn_registro.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra("valor", "hola");
                startActivity(intent);
            }
        }); */
    }

    @Override
    public void onClick(View view) {
        procesarEvento(view.getId());
    }
}