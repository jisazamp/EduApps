package com.example.eduapps.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.eduapps.R;

/*
 * Este es el splash que se muestra luego de que el usuario se registra en
 * la aplicación, y lo redirige al Home.
 */

public class SplashRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_register);

        // usamos el metodo postDelayed para hacer nuestro splash
        int SPLASH_SCREEN =3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashRegister.this,TeacherHomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}