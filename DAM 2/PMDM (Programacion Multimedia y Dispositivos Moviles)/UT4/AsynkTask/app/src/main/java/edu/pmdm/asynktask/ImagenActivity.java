package edu.pmdm.asynktask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ImagenActivity extends AppCompatActivity {

    private ArrayList<String> enlaces;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagen);

        Intent intent=getIntent();
        enlaces=intent.getStringArrayListExtra("URL");
        btnVolver=findViewById(R.id.btnVolver);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        añadirImagenes(enlaces);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void añadirImagenes(ArrayList<String> enlaces) {
        LinearLayout layout=findViewById(R.id.linearConstraint);

        for(String e : enlaces) {
            ImageView imagen=new ImageView(this);
            imagen.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            new DescargaImagen(imagen).execute(e);

            layout.addView(imagen);
        }
    }


    // AsyncTask para descargar y mostrar la imagen
    private class DescargaImagen extends AsyncTask<String, Void, Bitmap> {

        private ImageView imageView;

        public DescargaImagen(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String imageUrl = urls[0];  // La URL de la imagen a descargar
            Bitmap bitmap = null;

            try {
                // Intentamos descargar la imagen
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();

                // Obtenemos el InputStream de la conexión
                InputStream inputStream = connection.getInputStream();

                // Convertimos el InputStream en un Bitmap
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                // Establecemos la imagen descargada en el ImageView
                imageView.setImageBitmap(result);
            } else {
                // Si no se pudo descargar la imagen, podemos establecer un fallback o mensaje
                // imageView.setImageResource(R.drawable.placeholder); // Imagen por defecto
            }
        }
    }
}
