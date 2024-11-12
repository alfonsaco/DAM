package com.example.implicitintentsexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfigAtivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;
    EditText etxtCorreo=null;
    EditText etxtAsunto=null;
    EditText etxtMensaje=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_config_ativity);

        etxtAsunto=findViewById(R.id.etxtAsunto);
        etxtCorreo=findViewById(R.id.etxtCorreo);
        etxtMensaje=findViewById(R.id.etxtMensaje);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText etxtURL=findViewById(R.id.etxtURL);
        Button btnURL=findViewById(R.id.btnURL);


        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etxtURL.getText().toString();

                if(esURL(url)) {
                    Intent intent=new Intent();
                    intent.putExtra("URL", url);
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
                    Toast.makeText(ConfigAtivity.this,"URL no válida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnCorreo=findViewById(R.id.btnCorreo);
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String asunto=etxtAsunto.getText().toString();
                String correo=etxtCorreo.getText().toString();
                String mensaje=etxtMensaje.getText().toString();

                if(asunto != null && !asunto.equals("") && correo!=null && !correo.equals("") && mensaje!=null && !mensaje.equals("")) {
                    if(esCorreo(correo)) {
                        Intent i=new Intent();
                        intent.setData(Uri.parse("mailto:")); // Esto es necesario para usar el protocolo mailto

                        // Añadir la dirección de correo, asunto y cuerpo del mensaje
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"correo@ejemplo.com"});
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
                        intent.putExtra(Intent.EXTRA_TEXT, "Este es el cuerpo del mensaje.");

                        // Verificar si hay alguna aplicación para manejar este tipo de intent
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(),"Correo no válido", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(),"No puede haber campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean esCorreo(String correo) {
        return correo.matches("[a-zA-Z-.%]+@[a-zA-Z]+.[a-zA-Z]+");
    }

    private boolean esURL(String url) {
        return url.matches("^(https?://)?[a-zA-Z]+.[a-zA-Z0-9]+.[a-zA-Z]+");
    }
}