package com.example.implicitintentsexample;

import android.content.Intent;
import android.net.Uri;
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

        // Inicializamos los EditText
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

        // Obtenemos el EditText y Button para la URL
        EditText etxtURL=findViewById(R.id.etxtURL);
        Button btnURL=findViewById(R.id.btnURL);

        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etxtURL.getText().toString();
                // Verficamos que sea una URL
                if(esURL(url)) {
                    // Creamos un Intent para poder enviarla a la MainActivity
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

                if (asunto != null && !asunto.equals("") && correo != null && !correo.equals("") && mensaje != null && !mensaje.equals("")) {
                    if (esCorreo(correo)) {
                        // Enviar correo
                        Intent intent=new Intent();
                        intent.putExtra("correo",correo);
                        intent.putExtra("asunto", asunto);
                        intent.putExtra("mensaje", mensaje);
                        setResult(RESULT_OK, intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Correo no válido", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "No puede haber campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Método para verificar que el correo insertado por el usuario, sea un correo realmente
    private boolean esCorreo(String correo) {
        return correo.matches("[a-zA-Z-.%]+@[a-zA-Z]+.[a-zA-Z]+");
    }

    // Método para verificar que la URL insertada por el usuario sea válida
    private boolean esURL(String url) {
        return url.matches("^(https?://)?[a-zA-Z]+.[a-zA-Z0-9]+.[a-zA-Z]+");
    }
}