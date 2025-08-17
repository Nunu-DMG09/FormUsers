package com.example.formusers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;

public class VerUsers extends AppCompatActivity {

    TableLayout tableUsuarios;
    Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_users);

        tableUsuarios = findViewById(R.id.tableUsuarios);
        btnAtras = findViewById(R.id.btnAtras);

        for (String[] usuario : MainActivity.listaUsuarios) {
            TableRow row = new TableRow(this);

            TextView tvNombre = new TextView(this);
            tvNombre.setText(usuario[0]);
            tvNombre.setPadding(8, 8, 8, 8);

            TextView tvCorreo = new TextView(this);
            tvCorreo.setText(usuario[1]);
            tvCorreo.setPadding(8, 8, 8, 8);

            TextView tvGenero = new TextView(this);
            tvGenero.setText(usuario[2]);
            tvGenero.setPadding(8, 8, 8, 8);

            row.addView(tvNombre);
            row.addView(tvCorreo);
            row.addView(tvGenero);

            tableUsuarios.addView(row);
        }

        // Botón Atrás
        btnAtras.setOnClickListener(v -> {
            Intent intent = new Intent(VerUsers.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

}