package edu.pmdm.executealfonsorincon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImagenActivity extends AppCompatActivity {

    private ArrayList<String> enlaces;
    private ExecutorService executorService;  // Usamos un ExecutorService para las tareas en segundo plano
    private Handler mainHandler;  // Handler para actualizar la UI en el hilo principal
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagen);

        Intent intent = getIntent();
        enlaces = intent.getStringArrayListExtra("URL");
        btnVolver = findViewById(R.id.btnVolver);

        // Inicializar ExecutorService (un hilo para las tareas de descarga)
        executorService = Executors.newSingleThreadExecutor();
        mainHandler = new Handler(Looper.getMainLooper());  // Handler para actualizar la UI en el hilo principal

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        añadirImagenes(enlaces);

        btnVolver.setOnClickListener(view -> finish());
    }

    private void añadirImagenes(ArrayList<String> enlaces) {
        LinearLayout layout = findViewById(R.id.linearConstraint);

        for (String e : enlaces) {
            ImageView imagen = new ImageView(this);

            // Establecemos las LayoutParams para que las imágenes tengan un tamaño más adecuado
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,  // El ancho será el 100% del layout
                    (int) (getResources().getDisplayMetrics().heightPixels * 0.25)  // Limitar la altura de cada imagen al 25% de la altura de la pantalla
            );
            // Margen para separar una imagen de otra
            params.setMargins(0, 0, 0, 10);

            imagen.setLayoutParams(params);

            // Ejecutamos la descarga de la imagen en segundo plano
            executorService.submit(new DescargaImagenRunnable(imagen, e));

            layout.addView(imagen);
        }
    }

    // Runnable para descargar la imagen en segundo plano
    private class DescargaImagenRunnable implements Runnable {
        private final ImageView imageView;
        private final String imageUrl;

        public DescargaImagenRunnable(ImageView imageView, String imageUrl) {
            this.imageView = imageView;
            this.imageUrl = imageUrl;
        }

        @Override
        public void run() {
            Bitmap bitmap = descargarImagen(imageUrl);

            // Actualizamos la UI en el hilo principal usando el Handler
            mainHandler.post(() -> {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                }
            });
        }

        // Método para descargar la imagen
        private Bitmap descargarImagen(String imageUrl) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();

                // Obtener el InputStream de la conexión
                InputStream inputStream = connection.getInputStream();

                // Convertir el InputStream a Bitmap
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Aseguramos que el ExecutorService se cierre cuando la actividad se destruya
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
