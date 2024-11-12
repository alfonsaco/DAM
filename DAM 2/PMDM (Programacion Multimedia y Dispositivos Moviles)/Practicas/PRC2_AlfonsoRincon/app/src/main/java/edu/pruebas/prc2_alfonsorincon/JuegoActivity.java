package edu.pruebas.prc2_alfonsorincon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JuegoActivity extends AppCompatActivity {

    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tablero);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        partida=new Partida();
        partida.seleccionarDificultad("facil");
*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Funciones del ActionbBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    // Opciones del ToolBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        LayoutInflater inflater=getLayoutInflater();
        View dialogInflater=null;

        if(id == R.id.itemPersonaje) {
            dialogInflater=inflater.inflate(R.layout.intrucciones, null);
        } else if(id == R.id.itemReiniciar) {
            dialogInflater=inflater.inflate(R.layout.intrucciones, null);
        } else if(id == R.id.itemConfiguracion) {
            dialogInflater=inflater.inflate(R.layout.configuracion, null);
        } else if(id == R.id.itemInstrucciones) {
            dialogInflater=inflater.inflate(R.layout.intrucciones, null);
        }

        if(dialogInflater != null) {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setView(dialogInflater);

            builder.setCancelable(true);

            AlertDialog dialog = builder.create();
            dialog.show();

            if(id == R.id.itemInstrucciones) {
                Button btnOK=dialogInflater.findViewById(R.id.btnOK);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            } else if(id == R.id.itemConfiguracion) {
                Button btnVolver=dialogInflater.findViewById(R.id.btnVolver);

                btnVolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        }

        return true;
    }

}