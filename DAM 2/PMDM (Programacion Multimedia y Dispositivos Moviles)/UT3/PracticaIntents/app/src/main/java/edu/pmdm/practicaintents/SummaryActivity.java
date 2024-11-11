package edu.pmdm.practicaintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SummaryActivity extends AppCompatActivity {

    TextView txtNombre=null;
    TextView txtEdad=null;
    TextView txtCiudad=null;
    TextView txtPreferencia=null;
    Button btnVolver=null;
    Button btnEditar=null;
    String nombreIntent, edadIntent, ciudadIntent, preferenciaIntent;

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String nombreEditado = data.getStringExtra("nombre");
                            String edadEditada = data.getStringExtra("edad");
                            String ciudadEditada = data.getStringExtra("ciudad");
                            String preferenciaEditada = data.getStringExtra("preferencia");

                            // Actualiza los TextView con los datos modificados
                            txtNombre.setText(nombreEditado);
                            txtEdad.setText(edadEditada);
                            txtCiudad.setText(ciudadEditada);
                            txtPreferencia.setText(preferenciaEditada);
                        }
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        txtNombre=findViewById(R.id.txtNombre);
        txtCiudad=findViewById(R.id.txtCiudad);
        txtEdad=findViewById(R.id.txtEdad);
        txtPreferencia=findViewById(R.id.txtPreferencia);
        btnVolver=findViewById(R.id.btnVolver);
        btnEditar=findViewById(R.id.btnEditar);

        // Obtengo los valores
        Intent intent=getIntent();
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

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), EditActivity.class);
                i.putExtra("nombre", nombreIntent);
                i.putExtra("edad", edadIntent);
                i.putExtra("ciudad", ciudadIntent);
                i.putExtra("preferencia", preferenciaIntent);
                launcher.launch(i);
            }
        });
    }
}