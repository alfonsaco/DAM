package edu.pruebas.radiobuttonsexample;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener {

    RadioGroup rdGroup;
    TextView txtGusto;
    CheckBox CheckBox;
    TextView txtMensajeEquipo;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rdGroup=findViewById(R.id.radioGroup);
        rdGroup.setOnCheckedChangeListener(this);
        txtGusto=findViewById(R.id.txtGusto);
        CheckBox=findViewById(R.id.checkBox);
        CheckBox.setOnCheckedChangeListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedInt) {
        txtMensajeEquipo=findViewById(R.id.txtMensajeEquipo);
        imageView=findViewById(R.id.imageView);

        if(checkedInt == R.id.rbTalavera) {
            txtMensajeEquipo.setText("Buena elección, ¡El Talavera promete!");
            imageView.setImageResource(R.drawable.talavera);
        } else if(checkedInt == R.id.rbAlcazar) {
            txtMensajeEquipo.setText("¡Gran equipo la Gimnástica!");
            imageView.setImageResource(R.drawable.alcazar);
        } else if(checkedInt == R.id.rbAlbacete) {
            txtMensajeEquipo.setText("El Albacete no es el mismo desde que se fue Iniesta");
            imageView.setImageResource(R.drawable.albacete);
        } else {
            txtMensajeEquipo.setText("El dinero no lo es todo...");
            imageView.setImageResource(R.drawable.otros);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        txtGusto=findViewById(R.id.txtGusto);

        if(b == true) {
            txtGusto.setText("Te gusta el fútbol");
        } else {
            txtGusto.setText("No te gusta el fútbol");
        }
    }
}