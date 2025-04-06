package com.hfad.toolbarpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SintomasActivity extends AppCompatActivity {

    private EditText editTextNombreMascota, editTextSintomas;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        editTextNombreMascota = findViewById(R.id.editTextNombreMascota);
        editTextSintomas = findViewById(R.id.editTextSintomas);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        // Obtener el nombre desde el intent
        String nombreRecibido = getIntent().getStringExtra("nombreMascota");
        if (nombreRecibido != null) {
            editTextNombreMascota.setText(nombreRecibido);
        }

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombreMascota.getText().toString();
                String sintomas = editTextSintomas.getText().toString();

                if (!nombre.isEmpty() && !sintomas.isEmpty()) {
                    String mensaje = "Reporte de síntomas de " + nombre + ":\n\n" + sintomas;

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                    startActivity(Intent.createChooser(intent, "Compartir síntomas vía"));
                }
            }
        });
    }

}
