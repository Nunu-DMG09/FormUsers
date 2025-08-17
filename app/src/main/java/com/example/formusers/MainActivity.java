package com.example.formusers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etCorreo, etContrasena;
    RadioGroup rgGenero;
    CheckBox cbTerminos;
    Button btnRegistrar, btnSalir, btnVerUsuarios;

    static ArrayList<String[]> listaUsuarios = new ArrayList<>(); // Guardamos usuarios [nombre, correo, genero]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        rgGenero = findViewById(R.id.rgGenero);
        cbTerminos = findViewById(R.id.cbTerminos);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVerUsuarios = findViewById(R.id.btnVerUsuarios);
        btnSalir = findViewById(R.id.btnSalir);

        btnRegistrar.setOnClickListener(v -> registrarUsuario());
        btnVerUsuarios.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VerUsers.class);
            startActivity(intent);
        });

        btnSalir.setOnClickListener(v -> {
            finishAffinity();
        });
    }

    private void registrarUsuario() {
        String nombre = etNombre.getText().toString();
        String correo = etCorreo.getText().toString();
        String contrasena = etContrasena.getText().toString();

        int selectedId = rgGenero.getCheckedRadioButtonId();
        RadioButton rbSeleccionado = findViewById(selectedId);

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || selectedId == -1) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!cbTerminos.isChecked()) {
            Toast.makeText(this, "Debes aceptar los términos", Toast.LENGTH_SHORT).show();
            return;
        }

        String genero = rbSeleccionado.getText().toString();

        // Guardamos en el ArrayList
        listaUsuarios.add(new String[]{nombre, correo, genero});

        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();

        etNombre.setText("");
        etCorreo.setText("");
        etContrasena.setText("");
        rgGenero.clearCheck();
        cbTerminos.setChecked(false);
    }
}