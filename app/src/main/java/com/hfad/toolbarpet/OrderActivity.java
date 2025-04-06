package com.hfad.toolbarpet;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        List<Mascota> mascotas = (List<Mascota>) getIntent().getSerializableExtra("listaMascotas");
        TextView textView = findViewById(R.id.textViewMascotas);

        if (mascotas != null && !mascotas.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (Mascota mascota : mascotas) {
                builder.append(mascota.toString()).append("\n");
            }
            textView.setText(builder.toString());
        } else {
            textView.setText("No hay mascotas registradas.");
        }
    }
}