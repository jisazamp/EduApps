package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login = (Button)findViewById(R.id.loginButton);
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

        Button btn_registro = (Button)findViewById(R.id.registroButton);
        btn_registro.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra("valor", "hola");
                startActivity(intent);
            }
        });
    }
}