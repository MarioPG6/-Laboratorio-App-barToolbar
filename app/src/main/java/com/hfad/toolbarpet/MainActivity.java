package com.hfad.toolbarpet;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nombreMascota, especieMascota, edadMascota;
    private Button btnRegistrar;
    private List<Mascota> listaMascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombreMascota = findViewById(R.id.editTextNombre);
        especieMascota = findViewById(R.id.editTextEspecie);
        edadMascota = findViewById(R.id.editTextEdad);
        btnRegistrar = findViewById(R.id.buttonRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreMascota.getText().toString();
                String especie = especieMascota.getText().toString();
                String edadStr = edadMascota.getText().toString();

                if (!nombre.isEmpty() && !especie.isEmpty() && !edadStr.isEmpty()) {
                    int edad = Integer.parseInt(edadStr);

                    Mascota nuevaMascota = new Mascota(nombre, especie, edad);
                    listaMascotas.add(nuevaMascota);

                    Toast.makeText(MainActivity.this, "Mascota registrada: " + nuevaMascota, Toast.LENGTH_LONG).show();

                    // Limpiar campos
                    nombreMascota.setText("");
                    especieMascota.setText("");
                    edadMascota.setText("");

                    // Mostrar notificación
                    mostrarNotificacionMascota();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void mostrarNotificacionMascota() {
        // Crear canal (Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Canal Mascotas";
            String description = "Canal para notificaciones de mascotas";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("canal_mascotas", name, importance);
            channel.setDescription(description);

            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "canal_mascotas")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Mascota Registrada")
                .setContentText("Se ha registrado una nueva mascota.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_notificacion) {
            mostrarNotificacionMascota();
            return true;
        }

        if (item.getItemId() == R.id.action_evento) {
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("listaMascotas", new ArrayList<>(listaMascotas));
            startActivity(intent);
            return true;
        }

        if (item.getItemId() == R.id.action_sintomas) {
            Intent intent = new Intent(this, SintomasActivity.class);

            if (!listaMascotas.isEmpty()) {
                String nombreUltimaMascota = listaMascotas.get(listaMascotas.size() - 1).getNombre();
                intent.putExtra("nombreMascota", nombreUltimaMascota);
            }

            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



}
