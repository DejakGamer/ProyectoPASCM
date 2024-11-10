package com.example.proyectopascm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectopascm.ui.admin.HomeFragment;

public class Login extends AppCompatActivity {

    EditText user;
    EditText password;
    Button btnLogin;
    Button btnRegister;
    Button btnSalir;
    String userA  = "kevin1";
    String passA  = "kevin1";
    String userR  = "kevin2";
    String passR  = "kevin2";
    String userC  = "kevin3";
    String passC  = "kevin3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Asignación de vistas a variables
        btnLogin = findViewById(R.id.login_button);
        btnRegister = findViewById(R.id.register_button);
        btnSalir = findViewById(R.id.exit_button);
        user = findViewById(R.id.nombredeusuario);
        password = findViewById(R.id.contrasenalogin);

        // Configuración de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED; // Devuelve el insets correcto
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals(userA) && password.getText().toString().equals(passA)){
                    Intent intent = new Intent(view.getContext(), MainActivityAdmin.class);
                    startActivity(intent);
                    finish();
                }else if (user.getText().toString().equals(userR) && password.getText().toString().equals(passR)) {
                    Intent intent = new Intent(view.getContext(), MainActivityRepartidor.class);
                    startActivity(intent);
                    finish();
                } else if (user.getText().toString().equals(userC) && password.getText().toString().equals(passC)) {
                    Intent intent = new Intent(view.getContext(), MainActivityCliente.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(Login.this, "Usuario o Contraseña incorrecto", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Register.class);
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Gracias por usar la app!", Toast.LENGTH_LONG).show();
                finishAffinity();
            }
        });
    }
}
