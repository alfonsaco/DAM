package edu.pmdm.actividadopcional4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnSeleccionarColor;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSeleccionarColor=findViewById(R.id.btnSeleccionarColor);
        btnConfirmar=findViewById(R.id.btnConfirmar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        btnSeleccionarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creamos el AlertDialog

                View dialogView=getLayoutInflater().inflate(R.layout.dialog_style, null);
                builder.setView(dialogView);
                AlertDialog dialog=builder.create();

                // Variables del SeekBar y el TextView
                SeekBar seekRojo=dialogView.findViewById(R.id.seekRojo);
                SeekBar seekVerde=dialogView.findViewById(R.id.seekVerde);
                SeekBar seekAzul=dialogView.findViewById(R.id.seekAzul);
                TextView txtRojo=dialogView.findViewById(R.id.txtRojo);
                TextView txtVerde=dialogView.findViewById(R.id.txtVerde);
                TextView txtAzul=dialogView.findViewById(R.id.txtAzul);
                View viewColor=dialogView.findViewById(R.id.viewColor);

                viewColor.setBackgroundColor(Color.rgb(seekRojo.getProgress(), seekVerde.getProgress(), seekAzul.getProgress()));
                seekRojo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progreso, boolean b) {
                        viewColor.setBackgroundColor(Color.rgb(seekRojo.getProgress(),seekVerde.getProgress(),seekAzul.getProgress()));
                        txtRojo.setText("Rojo = "+progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                seekVerde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progreso, boolean b) {
                        viewColor.setBackgroundColor(Color.rgb(seekRojo.getProgress(),seekVerde.getProgress(),seekAzul.getProgress()));
                        txtVerde.setText("Verde = "+progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                seekAzul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progreso, boolean b) {
                        viewColor.setBackgroundColor(Color.rgb(seekRojo.getProgress(),seekVerde.getProgress(),seekAzul.getProgress()));
                        txtAzul.setText("Azul = "+progreso);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                // Botón de Confirmar del Dialog
                Button btnConfirmar=dialogView.findViewById(R.id.btnConfirmar);
                btnConfirmar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int rojo=seekRojo.getProgress();
                        int verde=seekVerde.getProgress();
                        int azul=seekAzul.getProgress();

                        int colorBoton=Color.rgb(rojo, verde, azul);
                        btnSeleccionarColor.setBackgroundColor(colorBoton);
                        dialog.dismiss();
                    }
                });
                
                dialog.show();
            }
        });
    }
}