package edu.pmdm.actividad2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnResult;
        TextView txtResult;
        EditText etxtNumber;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnResult=findViewById(R.id.btnResult);
        txtResult=findViewById(R.id.txtResult);
        etxtNumber=findViewById(R.id.etxtNumber);

        if(!etxtNumber.getText().toString().isEmpty()) {
            // Evento de pulsar el botón
            btnResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int numero=Integer.parseInt(String.valueOf(etxtNumber.getText()));

                    if(numero == 1) {
                        txtResult.setText("La posición 1 es del nº primo 1");
                    } else if(numero == 2) {
                        txtResult.setText("La posición 2 es del nº primo 1");
                    }

                }
            });
        }

    }
}