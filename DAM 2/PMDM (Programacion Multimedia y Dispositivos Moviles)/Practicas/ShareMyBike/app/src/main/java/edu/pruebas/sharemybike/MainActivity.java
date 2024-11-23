package edu.pruebas.sharemybike;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton btnUbi;
    boolean login=false;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnUbi=findViewById(R.id.btnUbi);
        btnLogin=findViewById(R.id.btnLogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        // Pulsar en el botón de ubicación y mostrar
        btnUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login=true;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Evitar que el usuario entre si no ha activado la dirección postal
                if(login == false) {
                    Toast.makeText(MainActivity.this, "Primero debes obtener la ubicación", Toast.LENGTH_SHORT).show();

                } else {

                }
            }
        });
    }
}