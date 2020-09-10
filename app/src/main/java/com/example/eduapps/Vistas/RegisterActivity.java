package com.example.eduapps.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduapps.Modelos.GlobalVariables;
import com.example.eduapps.Modelos.User;
import com.example.eduapps.R;

/*
 * Esta es la vista para registro del usuario.
 * Después de ingresar los datos de registro y presionar el botón de
 * "Registrar" lleva el usuario a una pantalla de Splash confirmando
 * su registro y luego llevándolo al Home.
 */

public class RegisterActivity extends AppCompatActivity {
    // variables globales
    EditText etName, etPassword, etConfirmPassword;
    String name, password, confirmPassword;
    User newUser;
    boolean userExists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // initialize edittext
        etName = (EditText)findViewById(R.id.regName);
        etPassword = (EditText)findViewById(R.id.regPassword);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        etConfirmPassword = (EditText)findViewById(R.id.regConfirmPassword);
        etConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());

        Button btn_registrar = (Button)findViewById(R.id.registrarButton);
        btn_registrar.setOnClickListener(new View.OnClickListener() {

            // metodo abstracto que tengo que implementar
            @Override
            public void onClick(View view) {
                // get the values from edittext fields
                name = etName.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();

                // check if passwords match
                if (password.equals(confirmPassword)) {
                    // initialize new user
                    newUser = new User(name, password);

                    // search if user exists
                    for (int i = 0; i < GlobalVariables.getInstance().users.size(); i++) {
                        User aux = GlobalVariables.getInstance().users.get(i);
                        if (name.equals(aux.getUsername())) {
                            userExists = true;
                        }
                    }

                    // add new user to arraylist
                    if(!userExists) {
                        GlobalVariables.getInstance().users.add(newUser);

                        // redirect to home activity
                        Intent intent;
                        intent = new Intent(RegisterActivity.this, TeacherHomeActivity.class);
                        intent.putExtra(getResources().getString(R.string.pnombre), newUser.getUsername().toString());
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "El usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}