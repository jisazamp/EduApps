package com.example.eduapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*
         * LAS LÍNEAS COMENTADAS ABAJO SON LAS QUE
         * ME ESTÁN CAUSANDO PROBLEMAS
         */

        Button btn = (Button)findViewById(R.id.agregarButton);
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            // metodo abstracto que tengo que implementar
//            @Override
//            public void onClick(View view) {
//                Intent intent;
//                intent = new Intent(SecondActivity.this, TeacherHomeActivity.class);
//                intent.putExtra("valor", "hola");
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}