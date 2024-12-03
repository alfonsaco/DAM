package edu.pmdm.asynktask;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etxtURL;
    Button btnAgregar;
    Button btnReset;
    private ArrayList<String> enlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etxtURL=findViewById(R.id.etxtURL);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnReset=findViewById(R.id.btnReset);
        enlaces=new ArrayList<>();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=String.valueOf(etxtURL.getText());

                if(url == null || url.equals("")) {
                    Toast.makeText(MainActivity.this, "No puedes dejar el campo vacío", Toast.LENGTH_SHORT).show();

                } else if(!esImagen(url)) {
                    Toast.makeText(MainActivity.this, "No puedes agregar más de 3 imágenes", Toast.LENGTH_SHORT).show();

                } else {
                    enlaces.add(url);

                    if(enlaces.size() > 3) {
                        Toast.makeText(MainActivity.this, "No puedes agregar más de 3 imágenes", Toast.LENGTH_SHORT).show();

                    } else {
                        Intent intent=new Intent(MainActivity.this, ImagenActivity.class);


                        intent.putExtra("URL", enlaces);
                        startActivity(intent);

                        etxtURL.setText("");
                    }
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enlaces.clear();
                Toast.makeText(MainActivity.this, "Todas las imágenes fueron eliminadas", Toast.LENGTH_SHORT).show();
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
}