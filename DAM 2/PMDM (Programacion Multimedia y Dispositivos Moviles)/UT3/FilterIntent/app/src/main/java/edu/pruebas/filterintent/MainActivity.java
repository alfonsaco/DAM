package edu.pruebas.filterintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView imagenMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imagenMostrar=findViewById(R.id.imagenMostrar);

        // Obtenemos el intent
        Intent intent=getIntent();

        // Verificar si el intent ha recibido un dato o no
        if (intent != null && intent.getAction() != null && intent.getAction().equals(Intent.ACTION_SEND)) {
            // Verificar si el dato es una imagen
            if (intent.getType()!=null && intent.getType().startsWith("image/")) {
                // URI de la imagen
                Uri uri=intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (uri != null) {
                    try {
                        // Se convierte la URI en un Bitmap para poder mostrarla en el ImageView
                        Bitmap bitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                        imagenMostrar.setImageBitmap(bitmap);

                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}