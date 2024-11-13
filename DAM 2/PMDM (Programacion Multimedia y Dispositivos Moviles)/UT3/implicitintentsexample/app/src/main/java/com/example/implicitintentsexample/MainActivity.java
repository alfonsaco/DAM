package com.example.implicitintentsexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
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

    Button btnAbrirWeb=null;
    Button btnEnviarCorreo=null;

    private ActivityResultLauncher<Intent> launcher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent data=result.getData();
                        if(data != null) {
                            // Obtenemos la URL del otro acivity
                            String urlModificada=data.getStringExtra("URL");
                            if(urlModificada != null) {
                                btnAbrirWeb.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        // Verificamos si contiene el https://. En caso contrario, se lo añadimos
                                        if(urlModificada.contains("https://")) {
                                            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(urlModificada));
                                            startActivity(i);
                                        } else {
                                            Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+urlModificada));
                                            startActivity(i);
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(getApplicationContext(), "URL no válida", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });

    private ActivityResultLauncher<Intent> launcherCorreo=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Intent data=result.getData();
                        if(data != null) {
                            // Obtenemos la URL del otro acivity
                            String urlModificada=data.getStringExtra("URL");
                            String correoEnviar;
                            String asuntoEnviar;
                            String mensajeEnviar;

                            if(urlModificada != null) {
                                btnEnviarCorreo.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        // Crear Intent con ACTION_SENDTO y mailto
                                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                                        intent.setData(Uri.parse("mailto:" + correo));
                                        // Asunto del email
                                        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                                        // Mensaje del email
                                        intent.putExtra(Intent.EXTRA_TEXT, mensaje);

                                        // Abrir el correo para poder enviar el email
                                        startActivity(intent);
                                    }
                                });
                            } else {
                                Toast.makeText(getApplicationContext(), "URL no válida", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Botón para abrir una página web
        btnAbrirWeb = findViewById(R.id.btnAbrirWeb);
        btnAbrirWeb.setOnClickListener(v -> {
            // Crear un intent implícito para abrir una página web
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        // Botón para enviar el correo
        btnEnviarCorreo=findViewById(R.id.btnEnviarCorreo);
        btnEnviarCorreo.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "No hay ningún correo para enviar", Toast.LENGTH_SHORT).show();
        });

        // Botón para realizar una llamada
        Button btnCamara=findViewById(R.id.btnCamara);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        // Boton para configurar la URL
        Button btnConfigurar=findViewById(R.id.btnConfigurar);
        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), ConfigAtivity.class);
                launcher.launch(i);
            }
        });
    }
}