package edu.pruebas.actividadopcional2;

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

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText etxtNombre;
    EditText etxtApellidos;
    EditText etxtFecha;
    EditText etxtNumHijos;
    EditText etxtSalarioBruto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCalcular=findViewById(R.id.btnCalcular);
        etxtNombre=findViewById(R.id.etxtNombre);
        etxtApellidos=findViewById(R.id.etxtApellidos);
        etxtFecha=findViewById(R.id.etxtFecha);
        etxtNumHijos=findViewById(R.id.etxtNumHijos);
        etxtSalarioBruto=findViewById(R.id.etxtSalarioBruto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Intent
        Intent intent=new Intent(this, ResultadoActivity.class);

        // Al pulsar el botón, nos llevará a la siguiente pantalla, que tendrá el resultado
//        if(!etxtApellidos.getText().toString().isEmpty() && !etxtFecha.getText().toString().isEmpty() && !etxtNombre.getText().toString().isEmpty() && !etxtNumHijos.getText().toString().isEmpty() && !etxtSalarioBruto.getText().toString().isEmpty()) {
            btnCalcular.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    // Variables
                    String nombre=String.valueOf(etxtNombre.getText());
                    String apellidos=String.valueOf(etxtApellidos.getText());

                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellidos", apellidos);

                    startActivity(intent);
                }
            });
//        }
    }
}