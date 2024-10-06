package edu.pruebas.actividadopcional1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton btnRat;
    ImageButton btnToro;
    ImageButton btnCerdo;
    ImageButton btnMono;
    ImageButton btnCabra;
    ImageButton btnCaballo;
    ImageButton btnSerpiente;
    ImageButton btnConejo;
    ImageButton btnDragon;
    ImageButton btnPerro;
    ImageButton btnGallo;
    ImageButton btnTigre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnRat=findViewById(R.id.btnRat);
        btnCaballo=findViewById(R.id.btnCaballo);
        btnToro = findViewById(R.id.btnToro);
        btnCerdo = findViewById(R.id.btnCerdo);
        btnMono = findViewById(R.id.btnMono);
        btnCabra = findViewById(R.id.btnCabra);
        btnSerpiente = findViewById(R.id.btnSerpiente);
        btnConejo = findViewById(R.id.btnConejo);
        btnDragon = findViewById(R.id.btnDragon);
        btnPerro = findViewById(R.id.btnPerro);
        btnGallo = findViewById(R.id.btnGallo);
        btnTigre = findViewById(R.id.btnTigre);

        // Click listeners, para cada uno de los casos
        btnCaballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Caballo", R.string.descripcion_caballo,R.drawable.caballo);
            }
        });

        btnRat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Rata", R.string.descripcion_rata, R.drawable.rata);
            }
        });

        btnToro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Toro", R.string.descripcion_toro, R.drawable.toro);
            }
        });

        btnCerdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Cerdo", R.string.descripcion_cerdo, R.drawable.cerdo);
            }
        });

        btnMono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Mono", R.string.descripcion_mono, R.drawable.mono);
            }
        });

        btnCabra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Cabra", R.string.descripcion_cabra, R.drawable.cabra);
            }
        });

        btnSerpiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Serpiente", R.string.descripcion_serpiente, R.drawable.serpiente);
            }
        });

        btnConejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Conejo", R.string.descripcion_conejo, R.drawable.conejo);
            }
        });

        btnDragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Dragón", R.string.descripcion_dragon, R.drawable.dragon);
            }
        });

        btnPerro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Perro", R.string.descripcion_perro, R.drawable.perro);
            }
        });

        btnGallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Gallo", R.string.descripcion_gallo, R.drawable.gallo);
            }
        });

        btnTigre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePantalla("Tigre", R.string.descripcion_tigre, R.drawable.tigre);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Función para llamar a la siguiente pantalla, junto con los respectivos atributos de cada imagen
    public void siguientePantalla(String titulo, int descripcion, int id) {
        Intent intent=new Intent(this, ImageActivity.class);
        intent.putExtra("signo",titulo);
        intent.putExtra("descripcion", descripcion);
        intent.putExtra("imagen",id);
        startActivity(intent);
    }
}