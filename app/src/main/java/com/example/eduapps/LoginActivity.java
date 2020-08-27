package com.example.eduapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduapps.Modelos.GlobalVariables;
import com.example.eduapps.Modelos.User;

/*
 * Esta es la vista para inicio de sesión del usuario.
 * Luego de ingresar las credenciales y presionar el botón de "iniciar
 * sesión", lleva al Home de la aplicación.
 */

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_iniciar_sesion;
    User user;
    boolean validCredentials = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        btn_iniciar_sesion = (Button)findViewById(R.id.iniciarSesionButton);

        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {

                // check for valid credentials
                for (int i = 0; i < GlobalVariables.getInstance().users.size(); i++) {
                    User aux = GlobalVariables.getInstance().users.get(i);
                    if (username.getText().toString().equals(aux.getUsername())) {
                        if (password.getText().toString().equals(aux.getPassword())) {
                            validCredentials = true;
                        }
                    }
                }

                if (validCredentials) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            LoginActivity.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Inicio de sesión correcto");
                    builder.setMessage("Bienvenido a EduApps");

                    builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    Intent intent;
                    intent = new Intent(LoginActivity.this, TeacherHomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}