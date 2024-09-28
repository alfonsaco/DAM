package edu.pruebas.actividadopcional3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnConvert;
        TextView txtRankine;
        TextView txtKelvin;
        TextView txtFahrenheit;
        EditText etxtDegree;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnConvert=findViewById(R.id.btnConvert);
        txtRankine=findViewById(R.id.txtRankine);
        txtKelvin=findViewById(R.id.txtKelvin);
        txtFahrenheit=findViewById(R.id.txtFahrenheit);
        etxtDegree=findViewById(R.id.etxtDegree);

        // Si el editText no está vacío, se ejecuta la función
        if(!btnConvert.getText().toString().isEmpty()) {
            btnConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double celsius=Double.parseDouble(String.valueOf(etxtDegree.getText()));
                    // Variables para cada temperatura
                    double rankine=(1.8 * celsius) + 491.67;
                    double kelvin=celsius + 273;
                    double fahrenheit=celsius * 1.8 + 32;

                    txtRankine.setText(String.valueOf(rankine));
                    txtKelvin.setText(String.valueOf(kelvin));
                    txtFahrenheit.setText(String.valueOf(fahrenheit));
                }
            });
        }
    }
}