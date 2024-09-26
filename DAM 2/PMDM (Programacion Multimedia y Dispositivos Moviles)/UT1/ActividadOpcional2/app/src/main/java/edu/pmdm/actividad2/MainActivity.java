package edu.pmdm.actividad2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
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

        // Elementos
        btnResult=findViewById(R.id.btnResult);
        txtResult=findViewById(R.id.txtResult);
        etxtNumber=findViewById(R.id.etxtNumber);

        //  Insertar números en la Criba de Eratóstenes
        int posicion=0;
        int[] cribaEratostenes=new int[1000];
        for (int i=1; i<cribaEratostenes.length; i++) {
            int contPrimoC=0;
            for (int e=0; e<i; e++) {
                if(i%2 == 0) {
                    contPrimoC++;
                }
            }
            if(contPrimoC <= 1) {
                posicion++;
                cribaEratostenes[posicion]=i;
            }
        }

        //if(!etxtNumber.getText().toString().isEmpty()) {
            // Evento de pulsar el botón
            btnResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int numero=Integer.parseInt(String.valueOf(etxtNumber.getText()));

                    // Imprimir texto por pantalla
                    for(int i=0; i<cribaEratostenes.length; i++) {
                        if(numero == cribaEratostenes[i]) {
                            txtResult.setText("La posición "+i+" es del nº primo "+numero);
                        }
                    }
                }
            });
        //}

    }
}