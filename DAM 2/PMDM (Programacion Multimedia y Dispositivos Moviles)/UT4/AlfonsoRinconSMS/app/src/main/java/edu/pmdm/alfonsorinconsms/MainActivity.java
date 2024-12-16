package edu.pmdm.alfonsorinconsms;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton btnBuscarNombre;
    ImageButton btnBuscarApellido;
    Button btnSeleccionar;
    EditText etxtNombre;
    EditText etxtApellido;
    ScrollView scrollContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnBuscarNombre=findViewById(R.id.btnBuscarNombre);
        btnBuscarApellido=findViewById(R.id.btnBuscarApellido);
        btnSeleccionar=findViewById(R.id.btnSeleccionar);
        etxtNombre=findViewById(R.id.etxtNombre);
        etxtApellido=findViewById(R.id.etxtApellido);
        scrollContactos=findViewById(R.id.scrollContactos);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etxtApellido.setVisibility(View.INVISIBLE);
        etxtNombre.setVisibility(View.INVISIBLE);
        btnBuscarApellido.setVisibility(View.INVISIBLE);
        btnBuscarNombre.setVisibility(View.INVISIBLE);

        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etxtApellido.setVisibility(View.VISIBLE);
                etxtNombre.setVisibility(View.VISIBLE);
                btnBuscarApellido.setVisibility(View.VISIBLE);
                btnBuscarNombre.setVisibility(View.VISIBLE);
            }
        });
    }
}