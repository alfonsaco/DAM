package com.example.contextproyect;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // En este ejemplo, usaremos el contexto para acceder a varios servicios y recursos del sistema, como SharedPreferences, AlarmManager, y AudioManager.
    private AudioManager audioManager;
    private SeekBar volumeSeekBar;
    int azulClaro;
    int moradoBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        azulClaro=ContextCompat.getColor(this, R.color.azul_claro);
        moradoBoton=ContextCompat.getColor(this, R.color.morado);

        // Inicializo las SharedPreferences
        SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        // Colores predeterminados para los botones
        int colorFondo=sharedPreferences.getInt("fondoColor", Color.WHITE);
        int colorBoton=sharedPreferences.getInt("botonColor", moradoBoton);

        androidx.constraintlayout.widget.ConstraintLayout layout=findViewById(R.id.main);
        Button btnFondo=findViewById(R.id.btnFondo);
        Button btnBotones=findViewById(R.id.btnBotones);
        Button buttonReadVolume=findViewById(R.id.buttonReadVolume);
        Button buttonStartActivity=findViewById(R.id.buttonStartActivity);

        // Aplicar colores guardados al fondo y a los botones
        layout.setBackgroundColor(colorFondo);
        btnFondo.setBackgroundColor(colorBoton);
        btnBotones.setBackgroundColor(colorBoton);
        buttonReadVolume.setBackgroundColor(colorBoton);
        buttonStartActivity.setBackgroundColor(colorBoton);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar AudioManager para gestionar el volumen del dispositivo
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Inicializar SeekBar para controlar el volumen
        volumeSeekBar = findViewById(R.id.volumeSeekBar);

        // Obtener el volumen máximo del dispositivo y configurarlo en la SeekBar
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar.setMax(maxVolume);

        // Leer el volumen guardado de SharedPreferences, o usar el volumen actual si no hay ninguno guardado
        int savedVolume = sharedPreferences.getInt("audioLevel", audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        volumeSeekBar.setProgress(savedVolume);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, savedVolume, 0);

        // Listener para detectar cambios en la SeekBar
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Ajustar el volumen con AudioManager
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

                // Guardar el nivel de audio en SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("audioLevel", progress);
                editor.apply();

                // Mostrar un Toast con el nivel de volumen guardado
                Toast.makeText(MainActivity.this, "Volumen guardado: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Botón para leer el volumen guardado
        buttonReadVolume.setOnClickListener(v -> {
            int currentSavedVolume = sharedPreferences.getInt("audioLevel", -1);
            Toast.makeText(MainActivity.this, "Volumen leído: " + currentSavedVolume, Toast.LENGTH_SHORT).show();
        });

        // Botón para iniciar la segunda actividad
        buttonStartActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Listener para cambiar el color de fondo
        btnFondo.setOnClickListener(view -> {
            int fondoAzul=azulClaro;
            layout.setBackgroundColor(fondoAzul);

            // Guardarmos el nuevo color de fondo
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("fondoColor", fondoAzul);
            editor.apply();

            Toast.makeText(MainActivity.this, "El color de fondo ha sido guardado", Toast.LENGTH_SHORT).show();
        });

        // Listener para cambiar el color de los botones
        btnBotones.setOnClickListener(view -> {
            int fondoBotonNuevo = Color.BLACK;
            btnBotones.setBackgroundColor(fondoBotonNuevo);
            btnFondo.setBackgroundColor(fondoBotonNuevo);
            buttonReadVolume.setBackgroundColor(fondoBotonNuevo);
            buttonStartActivity.setBackgroundColor(fondoBotonNuevo);

            // Guardarmos el nuevo color de los botones
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("botonColor", fondoBotonNuevo);
            editor.apply();

            Toast.makeText(MainActivity.this, "El color de botones ha sido guardado", Toast.LENGTH_SHORT).show();
        });
    }
}
