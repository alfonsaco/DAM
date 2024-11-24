package edu.pmdm.actividadparcelables;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VisualizarActivity extends AppCompatActivity {

    Button btnVolver;
    TextView txtDatos;
    TextView txtJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_visualizar);

        // Componentes
        btnVolver=findViewById(R.id.btnVolver);
        txtDatos=findViewById(R.id.txtDatos);
        txtJSON=findViewById(R.id.txtJSON);

        // Intent
        Intent intent=getIntent();
        Alumno a=intent.getParcelableExtra("alumno");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String datos="Nombre:"+a.getNombre()+"\nEdad: "+a.getEdad()+"\nNota Media: "+a.getMediaNotas();
        for (Asignatura asig : a.getAsignaturas()) {
            datos+="\n\n\t\tNombre: "+asig.getNombreAsignatura()+"\n\t\tNota: "+asig.getNotaAsignatura();
        }
        txtDatos.setText(datos);
        txtJSON.setText(a.convertirJSON());

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}