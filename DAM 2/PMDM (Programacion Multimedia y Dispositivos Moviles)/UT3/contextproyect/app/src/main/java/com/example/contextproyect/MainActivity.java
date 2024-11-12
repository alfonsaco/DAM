package com.example.contextproyect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private AudioManager audioManager;
    private SeekBar volumeSeekBar;
    private Button btnFondo, buttonReadVolume, buttonStartActivity, btnBotones;
    private ConstraintLayout layout;
    private SharedPreferences sharedPreferences;
    private int azulClaro;
    private int colorBotones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFondo = findViewById(R.id.btnFondo);
        buttonReadVolume = findViewById(R.id.buttonReadVolume);
        buttonStartActivity = findViewById(R.id.buttonStartActivity);
        btnBotones = findViewById(R.id.btnBotones);
        layout = findViewById(R.id.main);

        // SharedPreferences
        sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);

        // Aplicar colores guardados al iniciar la actividad
        int guardarFondo = sharedPreferences.getInt("colorFondo", azulClaro);
        layout.setBackgroundColor(guardarFondo);

        int guardarBoton = sharedPreferences.getInt("colorBoton", colorBotones);
        setButtonColors(guardarBoton);

        // Cambiar color de fondo
        btnFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Color de fondo azul
                azulClaro = ContextCompat.getColor(getApplicationContext(), R.color.azul_claro);
                layout.setBackgroundColor(azulClaro);

                // Guardar el color de fondo en SharedPreferences para que se quede al reiniciar
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("colorFondo", azulClaro);
                editor.apply();
            }
        });

        // Cambiar color de los botones
        btnBotones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorBotones=Color.BLACK;
                setButtonColors(colorBotones);
                // Guardar el color, para que se quede al reiniciar
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("colorBoton", colorBotones);
                editor.apply();
            }
        });
    }

    // Método para cambiar el color de los botones
    private void setButtonColors(int color) {
        btnFondo.setBackgroundColor(color);
        btnBotones.setBackgroundColor(color);
        buttonStartActivity.setBackgroundColor(color);
        buttonReadVolume.setBackgroundColor(color);
    }
}
