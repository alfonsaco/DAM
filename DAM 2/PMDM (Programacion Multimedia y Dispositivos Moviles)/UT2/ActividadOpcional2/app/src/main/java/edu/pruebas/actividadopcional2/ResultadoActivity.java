package edu.pruebas.actividadopcional2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    TextView txtInsertarNombre;
    TextView txtIRPF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        txtInsertarNombre=findViewById(R.id.txtInsertarNombre);
        txtIRPF=findViewById(R.id.txtIRPF);

        // Variables Intent
        Intent intent=getIntent();
        String nombre=intent.getStringExtra("nombre");
        String apellidos=intent.getStringExtra("apellidos");
        double irpf=intent.getDoubleExtra("irpf", -1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Resultado final
        txtInsertarNombre.setText(nombre+" "+apellidos);
        txtIRPF.setText(String.valueOf(irpf+"€"));
    }
}