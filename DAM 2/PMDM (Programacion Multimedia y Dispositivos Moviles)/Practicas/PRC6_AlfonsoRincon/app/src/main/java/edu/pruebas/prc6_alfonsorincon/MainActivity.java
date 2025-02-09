package edu.pruebas.prc6_alfonsorincon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerCanciones;
    private CancionAdapter adapter;
    private List<Cancion> listaCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerCanciones=findViewById(R.id.recyclerCanciones);
        recyclerCanciones.setLayoutManager(new LinearLayoutManager(this));

        String jsonString=leerJSON("recursosList.json");
        // Obtener los datos del JSON
        if(jsonString!=null){
            Gson gson=new Gson();
            RecursosWrapper wrapper=gson.fromJson(jsonString, RecursosWrapper.class);
            listaCanciones=wrapper.getListaRecursos();

            adapter=new CancionAdapter(this, listaCanciones);
            recyclerCanciones.setAdapter(adapter);

        }else{
            listaCanciones=new ArrayList<>();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para leer el JSON
    private String leerJSON(String archivo) {
        String json = null;

        try {
            InputStream is=getAssets().open(archivo);
            int tamaño=is.available();
            byte[] buffer=new byte[tamaño];
            is.read(buffer);
            is.close();
            json=new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}