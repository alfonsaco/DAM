package edu.pruebas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int SOLICITUD_NUEVO_LIBRO = 1;

    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private AdapterLibros adaptadorLibros;
    RecyclerView recycler;
    Button btnNuevoLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=findViewById(R.id.recycler);
        btnNuevoLibro=findViewById(R.id.btnAgregarLibro);

        // Configurar RecyclerView
        adaptadorLibros=new AdapterLibros(listaLibros);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adaptadorLibros);

        btnNuevoLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NuevoLibro.class);
                startActivityForResult(intent, SOLICITUD_NUEVO_LIBRO);
            }
        });
    }

    @Override
    protected void onActivityResult(int codigoSolicitud, int codigoResultado, @Nullable Intent datos) {
        super.onActivityResult(codigoSolicitud, codigoResultado, datos);

        if (codigoSolicitud == SOLICITUD_NUEVO_LIBRO && codigoResultado == RESULT_OK) {
            if (datos != null && datos.hasExtra("nuevoLibro")) {
                Libro nuevoLibro = datos.getParcelableExtra("nuevoLibro");
                if (nuevoLibro != null) {
                    listaLibros.add(nuevoLibro);
                    adaptadorLibros.notifyItemInserted(listaLibros.size() - 1);
                    Toast.makeText(this, "Libro añadido: " + nuevoLibro.getTitulo(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
