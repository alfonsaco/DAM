package edu.pruebas.prc6_alfonsorincon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);

        videoView=findViewById(R.id.videoView);
        mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        Intent intent=getIntent();
        String nombreVideo=intent.getStringExtra("uri");

        if(nombreVideo != null) {
            int videoID=getResources().getIdentifier(nombreVideo, "raw", getPackageName());
            if(videoID != 0) {
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoID);
                videoView.setVideoURI(videoUri);
                videoView.start();
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}