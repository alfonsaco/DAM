package edu.pmdm.practicaintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnEnviar=null;
    EditText etxtNombre=null;
    EditText etxtCiudad=null;
    EditText etxtEdad=null;
    RadioButton rbEclipse=null;
    RadioButton rbNetBeans=null;

    private ActivityResultLauncher<Intent> launcher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        // Recuperar los datos del Intent de SummaryActivity
                        Intent data=result.getData();
                        if (data != null) {
                            String nombre = data.getStringExtra("nombre");
                            String edad = data.getStringExtra("edad");
                            String ciudad = data.getStringExtra("ciudad");
                            String preferencia = data.getStringExtra("preferencia");

                            if (nombre.equals("") && edad.equals("") && ciudad.equals("") && preferencia.equals("")) {
                                etxtNombre.setText("");
                                etxtEdad.setText("");
                                etxtCiudad.setText("");
                                rbEclipse.setChecked(false);
                                rbNetBeans.setChecked(false);
                            }
                        }
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnEnviar=findViewById(R.id.btnEnviar);
        etxtNombre=findViewById(R.id.etxtNombreModificar);
        etxtCiudad=findViewById(R.id.etxtCiudad);
        etxtEdad=findViewById(R.id.etxtEdad);
        rbNetBeans=findViewById(R.id.rbNetBeans);
        rbEclipse=findViewById(R.id.rbEclipse);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=String.valueOf(etxtNombre.getText());
                String ciudad=String.valueOf(etxtCiudad.getText());
                String edad=String.valueOf(etxtEdad.getText());

                if(nombre.equals("") || ciudad.equals("") || edad.equals("")) {
                    Toast.makeText(MainActivity.this,"Hay campos vacíos", Toast.LENGTH_SHORT).show();

                } else {
                    // Verificar que esté seleccionada una opción
                    if(!rbEclipse.isChecked() && !rbNetBeans.isChecked()) {
                        Toast.makeText(MainActivity.this,"Selecciona una preferencia", Toast.LENGTH_SHORT).show();
                    } else {
                        String preferencia;
                        if(rbEclipse.isChecked()) {
                            preferencia="Eclipse";
                        } else {
                            preferencia="NetBeans";
                        }
                        Intent i=new Intent(getApplicationContext(), SummaryActivity.class);
                        i.putExtra("nombre", nombre);
                        i.putExtra("edad",edad);
                        i.putExtra("ciudad",ciudad);
                        i.putExtra("preferencia",preferencia);
                        launcher.launch(i);
                    }
                }
            }
        });
    }
}