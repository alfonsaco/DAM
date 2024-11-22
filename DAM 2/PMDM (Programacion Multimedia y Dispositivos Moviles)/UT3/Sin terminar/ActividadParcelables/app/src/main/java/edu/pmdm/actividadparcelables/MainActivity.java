package edu.pmdm.actividadparcelables;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnVisualizar;
    Button btnNuevaAsignatura;
    EditText etxtNota;
    EditText etxtNombreAsig;
    EditText etxtNombre;
    EditText etxtEdad;
    EditText etxtNotaMedia;
    String edadTexto;
    String nombre;
    String mediaTexto;
    private boolean mostrar=false;
    private ArrayList<Asignatura> asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnVisualizar=findViewById(R.id.btnVisualizar);
        btnNuevaAsignatura=findViewById(R.id.btnNuevaAsignatura);
        etxtNota=findViewById(R.id.etxtNota);
        etxtNombreAsig=findViewById(R.id.etxtNombreAsig);
        etxtNombre=findViewById(R.id.etxtNombre);
        etxtEdad=findViewById(R.id.etxtEdad);
        etxtNotaMedia=findViewById(R.id.etxtNotaMedia);

        // Incializo el ArrayList
        asignaturas=new ArrayList<>();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etxtNota.setVisibility(View.INVISIBLE);
        etxtNombreAsig.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnNuevaAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edadTexto=String.valueOf(etxtEdad.getText());
                nombre=String.valueOf(etxtNombre.getText());
                mediaTexto=String.valueOf(etxtNotaMedia.getText());

                // Evitar campos vacíos
                if(edadTexto == null || nombre == null || mediaTexto == null || edadTexto.isEmpty() || nombre.isEmpty() || mediaTexto.isEmpty()){
                    Toast.makeText(MainActivity.this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show();

                } else {
                    try {
                        int edad=Integer.parseInt(edadTexto);
                        double media=Double.parseDouble(mediaTexto);
                        // Verificar la edad
                        if(edad < 0 || edad > 110) {
                            Toast.makeText(MainActivity.this, "La edad debe estar entre 0 y 110", Toast.LENGTH_SHORT).show();
                            // Verificar la media
                        } else if(media < 0 || media > 10) {
                            Toast.makeText(MainActivity.this, "La media debe estar entre 0 y 10", Toast.LENGTH_SHORT).show();
                        } else {
                            // Mostramos los campos de asignatura
                            etxtNota.setVisibility(View.VISIBLE);
                            etxtNombreAsig.setVisibility(View.VISIBLE);

                            // Deshabilito estos campos
                            etxtEdad.setEnabled(false);
                            etxtNombre.setEnabled(false);
                            etxtNotaMedia.setEnabled(false);

                            String notaAsigTexto=String.valueOf(etxtNota.getText());
                            String nombreAsig=String.valueOf(etxtNombreAsig.getText());

                            mostrar=true;

                            // Verificar si se han agregado asignaturas o no
                            if(notaAsigTexto != null || nombreAsig != null || !notaAsigTexto.isEmpty() || !nombreAsig.isEmpty()){
                                try {
                                    double notaAsig=Double.parseDouble(notaAsigTexto);
                                    if(notaAsig < 0 || notaAsig > 10) {
                                        Toast.makeText(MainActivity.this, "La nota de la asignatura no es válida", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Asignatura asig=new Asignatura(notaAsig, nombreAsig);
                                        asignaturas.add(asig);

                                        Toast.makeText(MainActivity.this, "Asignatura agregada con éxito", Toast.LENGTH_SHORT).show();
                                        etxtNombreAsig.setText("");
                                        etxtNota.setText("");
                                    }

                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edadTexto == null || nombre == null || mediaTexto == null || edadTexto.isEmpty() || nombre.isEmpty() || mediaTexto.isEmpty() || mostrar==false){
                    Toast.makeText(MainActivity.this, "Rellena los campos de alumno", Toast.LENGTH_SHORT).show();
                } else {
                    Alumno alumno=new Alumno(Double.parseDouble(mediaTexto), Integer.parseInt(edadTexto), nombre, asignaturas);
                    Intent intent=new Intent(MainActivity.this, VisualizarActivity.class);
                    intent.putExtra("alumno", alumno);
                    startActivity(intent);
                }
            }
        });
    }
}