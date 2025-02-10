package edu.pruebas.prc6_alfonsorincon;

import android.media.MediaPlayer;
import android.widget.MediaController;
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

public class MainActivity extends AppCompatActivity implements MediaController.MediaPlayerControl {

    private RecyclerView recyclerCanciones;
    private CancionAdapter adapter;
    private List<Cancion> listaCanciones;

    private MediaPlayer mediaPlayer;
    private MediaController mediaController;

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

        mediaController=new MediaController(this);
        mediaController.setAnchorView(findViewById(R.id.main));

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

    public void reproducirCancion(int cancionID) {
        // Para controlar que no haya ya nada reproduciendo
        if (mediaPlayer != null) {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
        }

        mediaPlayer=MediaPlayer.create(this, cancionID);

        // Reproducirt canción y mostrar MediaControlelr
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaController.setMediaPlayer(this);
            mediaController.setEnabled(true);
            // Se pone el "0" para evitar que desaparezca el MediaController a los pocos segundos
            mediaController.show(0);
        }
    }

    @Override
    public void start() {
        if(mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public int getDuration() {
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        if(mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override
    public void seekTo(int pos) {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(pos);
        }
    }

    @Override
    public boolean isPlaying() {
        return (mediaPlayer != null) && mediaPlayer.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        if (mediaPlayer != null) {
            return mediaPlayer.getAudioSessionId();
        }
        return 0;
    }
}