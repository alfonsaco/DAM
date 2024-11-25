package edu.pruebas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NuevoLibro extends AppCompatActivity {

    EditText etxtTitulo, etxtAutor, etxtPublicacion, etxtDescripcion;
    Button btnNuevoLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_libro);

        etxtTitulo = findViewById(R.id.etxtTitulo);
        etxtAutor = findViewById(R.id.etxtAutor);
        etxtPublicacion = findViewById(R.id.etxtPublicacion);
        etxtDescripcion = findViewById(R.id.etxtDescripcion);
        btnNuevoLibro = findViewById(R.id.btnNuevoLibro);

        btnNuevoLibro.setOnClickListener(view -> agregarLibro());
    }

    private void agregarLibro() {
        String titulo=etxtTitulo.getText().toString();
        String autor=etxtAutor.getText().toString();
        String publicacionTexto=etxtPublicacion.getText().toString();
        String descripcion=etxtDescripcion.getText().toString();

        if (titulo.isEmpty() || autor.isEmpty() || publicacionTexto.isEmpty() || descripcion.isEmpty()) {
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();

        } else {
            try {
                int publicacion = Integer.parseInt(publicacionTexto);
                if (publicacion > 2024) {
                    Toast.makeText(this, "Año no válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Crear el libro y se envía como resultado del Intent
                Libro libro = new Libro(titulo, autor, publicacion, descripcion);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nuevoLibro", libro);
                setResult(RESULT_OK, resultIntent);

                finish();

            } catch (NumberFormatException e) {
                Toast.makeText(this, "El año debe ser un número válido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
