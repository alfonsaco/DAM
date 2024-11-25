package edu.pruebas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NuevoLibro extends AppCompatActivity {

    EditText etxtTitulo;
    EditText etxtAutor;
    EditText etxtPublicacion;
    EditText etxtDescripcion;
    Button btnNuevoLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_libro);

        etxtTitulo=findViewById(R.id.etxtTitulo);
        etxtAutor=findViewById(R.id.etxtAutor);
        etxtPublicacion=findViewById(R.id.etxtPublicacion);
        etxtDescripcion=findViewById(R.id.etxtDescripcion);
        btnNuevoLibro=findViewById(R.id.btnNuevoLibro);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnNuevoLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo=String.valueOf(etxtTitulo.getText());
                String autor=String.valueOf(etxtAutor.getText());
                String añoTetxo=String.valueOf(etxtPublicacion.getText());
                String descripcion=String.valueOf(etxtDescripcion.getText());

                if(titulo.isEmpty() || autor.isEmpty() || añoTetxo.isEmpty() || descripcion.isEmpty() || titulo == null || autor == null || añoTetxo == null || descripcion == null) {
                    Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int año=Integer.parseInt(String.valueOf(etxtPublicacion.getText()));
                        if(año > 2024) {
                            Toast.makeText(getApplicationContext(), "Año no válido", Toast.LENGTH_SHORT).show();
                        } else {
                            Libro libro=new Libro(titulo, autor, año, descripcion);
                            Intent resultIntent=new Intent();
                            resultIntent.putExtra("nuevoLibro", libro);
                            setResult(RESULT_OK, resultIntent);
                            finish();
                        }

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}