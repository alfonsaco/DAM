package edu.pmdm.prc1_alfonsorincon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Inicialiamos los elementos
    ImageButton btnPlay;
    EditText etxtSets;
    EditText etxtWork;
    EditText etxtRest;
    CountDownTimer timer;
    TextView txtSecondsLeft;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Variables asociadas a los elementos
        txtSecondsLeft=findViewById(R.id.txtSecondsLeft);
        btnPlay=findViewById(R.id.btnPlay);
        etxtSets=findViewById(R.id.etxtSets);
        etxtWork=findViewById(R.id.etxtWork);
        etxtRest=findViewById(R.id.etxtRest);
        constraintLayout=findViewById(R.id.constraintLayout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        // Comienzo del programa al pulsar en el botón
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etxtRest.getText().toString().isEmpty() && !etxtSets.getText().toString().isEmpty() && !etxtWork.getText().toString().isEmpty()) {

                    int sets=Integer.parseInt(etxtSets.getText().toString());
                    int work=Integer.parseInt(etxtWork.getText().toString());
                    int rest=Integer.parseInt(etxtRest.getText().toString());
                    int cont=5;

                    for (int i=0; i<sets; i++) {
                        cont--;
                        exerciseCounter(work, rest, cont);
                    }


                } else {
                    // Se mostrará un alerta, en caso de que haya campos sin rellenar
                    AlertDialog alerta=new AlertDialog.Builder(MainActivity.this)
                            .setTitle("HAY CAMPOS SIN RELLENAR")
                            .setMessage("Debes rellenar todos los campos")
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Acción al presionar el botón "Aceptar"
                                    dialog.dismiss(); // Cerrar el diálogo
                                }
                            })
                            .show();
                }
            }

        });


    }

    // Funición para el contador de descanso
    private void restCounter(int resting, int cont) {
        constraintLayout.setBackgroundColor(Color.rgb(255, 129, 110));

        timer=new CountDownTimer(resting, 1000) {
            @Override
            public void onTick(long l) {
                txtSecondsLeft.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                txtSecondsLeft.setText("a");
                if(cont == 0) {
                    constraintLayout.setBackgroundColor(Color.rgb(255, 255, 255));
                }
            }
        }.start();
    }

    // Función para ejecutar el contador de ejercicio, y cambiar el fondo a verde.
    // Se pondrá fuera del onCreate, ya que no se pueden definir métodos dentro de otro
    private void exerciseCounter(int total, int rest, int cont) {
        constraintLayout.setBackgroundColor(Color.rgb(144, 255, 110));

        int totalFinal=total*1000;
        timer=new CountDownTimer(totalFinal, 1000) {
            @Override
            public void onTick(long l) {
                txtSecondsLeft.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                restCounter(rest, cont);
                txtSecondsLeft.setText("CONTADOR FINALIZADOS");
            }
        }.start();
    }

}