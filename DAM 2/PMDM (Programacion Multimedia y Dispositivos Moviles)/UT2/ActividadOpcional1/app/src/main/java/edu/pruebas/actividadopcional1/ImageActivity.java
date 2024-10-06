package edu.pruebas.actividadopcional1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImageActivity extends AppCompatActivity {

    Button btnVolver;
    TextView txtNombre;
    TextView txtDescripcion;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);

        btnVolver=findViewById(R.id.btnVolver);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        txtNombre=findViewById(R.id.txtNombre);
        imageView=findViewById(R.id.imageView);

        // Obtenemos los datos del intent
        Intent intent=getIntent();
        String signo=intent.getStringExtra("signo");
        String descripcion=getString(intent.getIntExtra("descripcion", -1));
        int imageId=intent.getIntExtra("imagen", -1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNombre.setText(signo);
        txtDescripcion.setText(descripcion);
        imageView.setImageResource(imageId);
    }

    // Volver a la pantalla principal
    @Override
    protected void onResume() {
        super.onResume();
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}