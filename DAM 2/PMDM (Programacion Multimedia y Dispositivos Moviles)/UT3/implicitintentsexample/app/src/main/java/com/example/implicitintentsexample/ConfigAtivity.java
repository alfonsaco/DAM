package com.example.implicitintentsexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfigAtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_config_ativity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText etxtURL=findViewById(R.id.etxtURL);
        Button btnURL=findViewById(R.id.btnURL);


        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=String.valueOf(etxtURL.getText());

                if(esURL(url)) {


                    finish();
                } else {
                    Toast.makeText(ConfigAtivity.this,"URL no válida", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnCorreo=findViewById(R.id.btnCorreo);
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private boolean esCorreo(String correo) {
        return correo.matches("[a-zA-Z-.%]+@[a-zA-Z]+.[a-zA-Z]+");
    }

    private boolean esURL(String url) {
        return url.matches("[a-zA-Z]+.[a-zA-Z0-9]+.[a-zA-Z]+");
    }
}