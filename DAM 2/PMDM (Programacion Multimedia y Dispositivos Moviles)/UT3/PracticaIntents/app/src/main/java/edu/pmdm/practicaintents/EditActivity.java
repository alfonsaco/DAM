package edu.pmdm.practicaintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditActivity extends AppCompatActivity {

    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit);

        EditText etxtNombreModificar=findViewById(R.id.etxtNombreModificar);
        EditText etxtEdadModificar=findViewById(R.id.etxtEdadModificar);
        EditText etxtCiudadModificar=findViewById(R.id.etxtCiudadModificar);
        EditText etxPreferenciaModificar=findViewById(R.id.etxPreferenciaModificar);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String edad = intent.getStringExtra("edad");
        String ciudad = intent.getStringExtra("ciudad");
        String preferencia = intent.getStringExtra("preferencia");

        etxtNombreModificar.setText(nombre);
        etxtCiudadModificar.setText(ciudad);
        etxtEdadModificar.setText(edad);
        etxPreferenciaModificar.setText(preferencia);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button btnGuardar=findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });
    }
}