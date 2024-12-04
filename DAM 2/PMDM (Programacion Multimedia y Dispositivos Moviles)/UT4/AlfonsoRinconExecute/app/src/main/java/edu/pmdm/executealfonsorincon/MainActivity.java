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

        // Inicializamos el ExecutorService con un solo hilo
        executorService=Executors.newSingleThreadExecutor();

        // Coponentes del XML
        txtDescarga = findViewById(R.id.txtDescarga);
        txtDescarga.setMovementMethod(new ScrollingMovementMethod());
        etxtURLImagen=findViewById(R.id.etxtURLImagen);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnReset=findViewById(R.id.btnReset);
        txtCont=findViewById(R.id.txtCont);

        // ArrayList con los enlaces de las imágenes
        enlaces=new ArrayList<>();

        // Evento de Click en el botón para agregar imágenes
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=String.valueOf(etxtURLImagen.getText());

                // Campo vacío
                if(url.equals("")) {
                    Toast.makeText(MainActivity.this, "No puedes dejar el campo vacío", Toast.LENGTH_SHORT).show();

                } else {
                    // Verificar que sea URL
                    if(!esImagen(url)) {
                        Toast.makeText(MainActivity.this, "Enlace no válido", Toast.LENGTH_SHORT).show();
                    } else {
                        enlaces.add(url);
                        // No se pueden agergar más de 3 imágenes
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

        // Se vacía el arrayList de imágenes al pulsar en este botón
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

    // Método para verificar que sea URL
    private boolean esImagen(String url) {
        if (url != null && !url.isEmpty()) {
            Pattern pattern=Pattern.compile("^(https?://)?[a-zA-Z0-9\\-]+(\\.[a-zA-Z]{2,})+(/[^\\s]*)?\\.(png|jpg|jpeg|gif|bmp|webp)$", Pattern.CASE_INSENSITIVE);
            Matcher matcher=pattern.matcher(url);

            // Condicional para verificar que no se hayan concatenado URL
            if (matcher.matches()) {
                // Su busca si hay más de 1 coincidencia del http. Si lo hace, es que está mal porque se han concatenado
                if (url.indexOf("http", url.indexOf("://") + 3) != -1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    // Método para descargar la imagen a través de la URL en segundo plano
    public void Descargar(View v) {
        EditText etxtURL=findViewById(R.id.etxtURL);

        // Comprobamos si hay conexión a Internet
        ConnectivityManager connMgr=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connMgr.getActiveNetworkInfo();

        // En el caso de que haya una red activa
        if (networkInfo != null && networkInfo.isConnected()) {
            String url=etxtURL.getText().toString();
            // Enviamos la tarea de descarga al ExecutorService
            executorService.submit(new DescargaRunnable(url));

        } else {
            etxtURL.setText("No se ha podido establecer conexión a internet");
        }
    }

    // Clase Runnable que realiza la descarga de la URL en segundo plano
    private class DescargaRunnable implements Runnable {
        private String url;

        // Constructor
        DescargaRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            // Método ejecutado en un hilo en segundo plano
            try {
                // Intentamos descargar el contenido de la URL
                String resultado=descargaUrl(url);

                new Handler(Looper.getMainLooper()).post(() -> txtDescarga.setText(resultado));

            } catch (IOException e) {
                new Handler(Looper.getMainLooper()).post(() -> txtDescarga.setText("Imposible cargar la web! URL mal formada"));
            }
        }

        // Método que realiza la descarga de la URL en un InputStream y devuelve el contenido como un String
        private String descargaUrl(String myurl) throws IOException {
            InputStream is=null;

            try {
                URL url=new URL(myurl);
                // Conexion HTTP
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milisegundos */);
                conn.setConnectTimeout(15000 /* milisegundos */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                int response=conn.getResponseCode();
                is=conn.getInputStream();

                // Se devuelve el InpuStream
                return leer(is);

            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }

        // Método para leer los datos de un InputStream y convertirlos a un String
        private String leer(InputStream is) {
            try {
                ByteArrayOutputStream bo=new ByteArrayOutputStream();
                int i=is.read();

                // Leemos los bytes del InputStream y los escribimos en el ByteArrayOutputStream
                while (i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                // Devolvemos el contenido cnvertido en una cadena de texto
                return bo.toString();

            } catch (IOException e) {
                return "";
            }
        }
    }

    // Con esto se evitan fugas de memoria
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Para que el executor se cierre al cerrar la app
        if (executorService != null) {
            executorService.shutdown();
        }
    }

}
