package edu.pmdm.practicaintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

        // Obtén las referencias de los campos de entrada
        EditText etxtNombreModificar = findViewById(R.id.etxtNombreModificar);
        EditText etxtEdadModificar = findViewById(R.id.etxtEdadModificar);
        EditText etxtCiudadModificar = findViewById(R.id.etxtCiudadModificar);
        EditText etxPreferenciaModificar = findViewById(R.id.etxPreferenciaModificar);

        // Configura el botón Guardar
        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un Intent para devolver los datos modificados
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nombre", etxtNombreModificar.getText().toString());
                resultIntent.putExtra("edad", etxtEdadModificar.getText().toString());
                resultIntent.putExtra("ciudad", etxtCiudadModificar.getText().toString());
                resultIntent.putExtra("preferencia", etxPreferenciaModificar.getText().toString());

                // Configura el resultado de la actividad
                setResult(RESULT_OK, resultIntent);

                // Finaliza la actividad
                finish();
            }
        });
    }
}