package edu.pmdm.practicaintents;

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

public class SecondActivity extends AppCompatActivity {

    TextView txtNombre;
    TextView txtEdad;
    TextView txtCiudad;
    TextView txtPreferencia;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();

        txtNombre=findViewById(R.id.txtNombre);
        txtCiudad=findViewById(R.id.txtCiudad);
        txtEdad=findViewById(R.id.txtEdad);
        txtPreferencia=findViewById(R.id.txtPreferencia);
        btnVolver=findViewById(R.id.btnVolver);

        // Obtengo los varlores
        String nombreIntent=intent.getStringExtra("nombre");
        String edadIntent=intent.getStringExtra("edad");
        String ciudadIntent=intent.getStringExtra("ciudad");
        String preferenciaIntent=intent.getStringExtra("preferencia");

        // Los pongo en su respectivo campo
        txtNombre.setText(nombreIntent);
        txtEdad.setText(edadIntent);
        txtCiudad.setText(ciudadIntent);
        txtPreferencia.setText(preferenciaIntent);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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