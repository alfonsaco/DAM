package edu.pmdm.executealfonsorincon;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView txtDescarga;
    ExecutorService executorService;
    EditText etxtURLImagen;
    Button btnAgregar;
    Button btnReset;
    TextView txtCont;
    private int contImagenes=0;
    private ArrayList<String> enlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos el ExecutorService con un solo hilo para las tareas en segundo plano.
        executorService = Executors.newSingleThreadExecutor();

        // Configuramos la vista de texto para hacerla desplazable.
        txtDescarga = findViewById(R.id.txtDescarga);
        txtDescarga.setMovementMethod(new ScrollingMovementMethod());
        etxtURLImagen=findViewById(R.id.etxtURLImagen);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnReset=findViewById(R.id.btnReset);
        txtCont=findViewById(R.id.txtCont);

        // ArrayList con los enlaces de las imágenes
        enlaces=new ArrayList<>();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=String.valueOf(etxtURLImagen.getText());

                if(url.equals("")) {
                    Toast.makeText(MainActivity.this, "No puedes dejar el campo vacío", Toast.LENGTH_SHORT).show();

                } else {
                    if(!esImagen(url)) {
                        Toast.makeText(MainActivity.this, "Enlace no válido", Toast.LENGTH_SHORT).show();
                    } else {
                        enlaces.add(url);

                        if(enlaces.size() > 3) {
                            Toast.makeText(MainActivity.this, "No puedes agregar más de 3 imágenes", Toast.LENGTH_SHORT).show();

                        } else {
                            Intent intent=new Intent(MainActivity.this, ImagenActivity.class);
                            intent.putExtra("URL", enlaces);
                            startActivity(intent);

                            contImagenes++;
                            txtCont.setText(String.valueOf(contImagenes)+" / 3");

                            etxtURLImagen.setText("");
                        }
                    }
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enlaces.clear();
                Toast.makeText(MainActivity.this, "Todas las imágenes fueron eliminadas", Toast.LENGTH_SHORT).show();
                contImagenes=0;
                txtCont.setText(String.valueOf(contImagenes)+" / 3");
            }
        });
    }

    private boolean esImagen(String url) {
        if (url != null && !url.isEmpty()) {
            Pattern pattern = Pattern.compile("^(https?://)?[a-zA-Z0-9\\-]+(\\.[a-zA-Z]{2,})+(/[^\\s]*)?\\.(png|jpg|jpeg|gif|bmp|webp)$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(url);
            return matcher.matches();
        }
        return false;
    }

    public void Descargar(View v) {
        EditText etxtURL = findViewById(R.id.etxtURL);
        txtDescarga = findViewById(R.id.txtDescarga);

        // Comprobamos si hay conexión a Internet.
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // Ejecutamos la tarea de descarga en segundo plano usando el ExecutorService.
            String url = etxtURL.getText().toString();
            executorService.submit(new DescargaRunnable(url));
        } else {
            etxtURL.setText("No se ha podido establecer conexión a internet");
        }
    }

    private class DescargaRunnable implements Runnable {
        private String url;

        DescargaRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            // Ejecutamos la descarga en segundo plano.
            try {
                String resultado = descargaUrl(url);

                // Usamos un Handler para actualizar la UI en el hilo principal.
                new Handler(Looper.getMainLooper()).post(() -> txtDescarga.setText(resultado));

            } catch (IOException e) {
                // En caso de error, mostramos el mensaje de error en la UI.
                new Handler(Looper.getMainLooper()).post(() -> txtDescarga.setText("Imposible cargar la web! URL mal formada"));
            }
        }

        private String descargaUrl(String myurl) throws IOException {
            InputStream is = null;

            try {
                // Realizamos la conexión HTTP para obtener el contenido de la página.
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milisegundos */);
                conn.setConnectTimeout(15000 /* milisegundos */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                int response = conn.getResponseCode(); // obtenemos el código de respuesta
                is = conn.getInputStream(); // obtenemos el InputStream de la respuesta

                // Convertimos el InputStream a String.
                return leer(is);
            } finally {
                if (is != null) {
                    // Cerramos el InputStream.
                    is.close();
                }
            }
        }

        private String leer(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while (i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString();
            } catch (IOException e) {
                return "";
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Aseguramos que el ExecutorService sea cerrado cuando se destruya la actividad.
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
