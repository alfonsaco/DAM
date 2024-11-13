package edu.pruebas.prc2_alfonsorincon;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.gridlayout.widget.GridLayout;

import java.util.ArrayList;

public class JuegoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Partida partida;
    private Spinner spinner;
    private int personajeSeleccionado=R.drawable.submarina;
    // Array de los botones. Como algunos son ImageButtons, y otro Buttons, no se pueden
    // almacenar en un array de Buttons, por ejemplo, por lo que los almaceno en un Array de
    // View, ya que ambos heredan de esta clase.
    private View[][] buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tablero);

        // Crear la ToolBar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Línea de código para poder cambiar el color de los 3 puntitos de la ToolBar
        if(toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        // Partida
        partida=new Partida();

        /*
        partida=new Partida();
        partida.seleccionarDificultad("facil");
*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Comenzar la partida al iniciar la actividad
        partida.comenzar(8, 8, 10, this);

    }

    // Funciones del ActionbBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem item=menu.findItem(R.id.itemPersonaje);
        item.setIcon(personajeSeleccionado);
        return true;
    }

    // Opciones del ToolBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        LayoutInflater inflater=getLayoutInflater();
        View dialogInflater=null;

        // Crear el Spinner, en caso de que se haya seleccionado la opción de personajes en el ToolBar
        if(id == R.id.itemPersonaje) {
            dialogInflater = inflater.inflate(R.layout.personaje, null);

            // Spinner de diálogo
            Spinner dialogSpinner = dialogInflater.findViewById(R.id.spinner);

            // Agregamos todos los elementos al Spinner
            ArrayList<Items> elementosSpinner = new ArrayList<>();
            elementosSpinner.add(new Items("Bomba clásica", R.drawable.clasica));
            elementosSpinner.add(new Items("TNT", R.drawable.tnt));
            elementosSpinner.add(new Items("Granada", R.drawable.granada));
            elementosSpinner.add(new Items("Mina marina", R.drawable.submarina));
            elementosSpinner.add(new Items("Bomba Mario Bros", R.drawable.mariobros));

            // Creación del adaptador y asignación al Spinner del diálogo
            Adapter adapter = new Adapter(this, elementosSpinner);
            dialogSpinner.setAdapter(adapter);
            dialogSpinner.setOnItemSelectedListener(this);

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

            // Funciones de la opción de las intrucciones
            if(id == R.id.itemInstrucciones) {
                Button btnOK=dialogInflater.findViewById(R.id.btnOKpersonaje);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                // Funciones de la opción de la configuración
            } else if(id == R.id.itemConfiguracion) {
                final View finalDialogInflater=dialogInflater;
                Button btnVolver=finalDialogInflater.findViewById(R.id.btnVolver);

                btnVolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RadioButton rdPrincipiante=finalDialogInflater.findViewById(R.id.rdPrincipiante);
                        RadioButton rdAmateur=finalDialogInflater.findViewById(R.id.rdAmateur);
                        RadioButton rdAvanzado=finalDialogInflater.findViewById(R.id.rdAvanzado);

                        // Condicionales para ver que dificultad se ha elegido, y así poder crear una nueva partida
                        if(rdPrincipiante != null && rdPrincipiante.isChecked()) {
                            partida.comenzar(8, 8, 10, JuegoActivity.this);
                        } else if(rdAmateur != null && rdAmateur.isChecked()) {
                            partida.comenzar(12, 12, 30, JuegoActivity.this);
                        } else if(rdAvanzado != null && rdAvanzado.isChecked()) {
                            partida.comenzar(16, 16, 60, JuegoActivity.this);
                        }

                        dialog.dismiss();
                    }
                });

                // Funciones de la opción de elegir personaje
            } else if(id == R.id.itemPersonaje) {
                Button btnOKpersonaje=dialogInflater.findViewById(R.id.btnOKpersonaje);

                btnOKpersonaje.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Usamos invalidateOptionsMenu(), para recrear el ToolBar, y así, poner la nueva imagen que hemos seleccionado.
                        // Gracias a esto, el icono se actualizará
                        invalidateOptionsMenu();
                        dialog.dismiss();
                    }
                });
            }
        }

        return true;
    }

    // Métodos del Spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Items items=(Items)adapterView.getSelectedItem();
        // Una vez seleccionado el nuevo personaje, será este. Lo podremos utilizar más tarde
        personajeSeleccionado=items.getImagen();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Método para crear el grid mediante el array de números
    public void crearTablero(int[][] tablero, int tamañoGrid) {
        android.widget.GridLayout gridLayout=findViewById(R.id.gridLayout);
        gridLayout.setRowCount(tamañoGrid);
        gridLayout.setColumnCount(tamañoGrid);

        // Definir el tamaño del botón
        //      getDisplayMetrics(): contiene información sobre la pantalla del dispositivo
        //      widthPixels: devuelve el ancho en píxeles
        int buttonSize=getResources().getDisplayMetrics().widthPixels / tamañoGrid;
        buttons=new View[tamañoGrid][tamañoGrid];

        for (int i=0; i<tablero.length; i++) {
            for (int e=0; e<tablero[i].length; e++) {
                if(tablero[i][e] == -1) {
                    ImageButton button=new ImageButton(this);

                    // Configuración básica para ambos tipos de botón
                    button.setLayoutParams(new android.widget.GridLayout.LayoutParams());
                    button.getLayoutParams().width = buttonSize;
                    button.getLayoutParams().height = buttonSize;

                    // Guardar el botón en el array de View
                    buttons[i][e] = button;

                    // Configurar comportamiento al hacer clic
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Acción al hacer clic en la casilla
                            if (v instanceof ImageButton) {
                                // Acciones para la mina
                            } else if (v instanceof Button) {
                                // Acciones para una casilla normal
                            }
                        }
                    });

                    // Añadir el botón al GridLayout
                    gridLayout.addView(button);
                } else {
                    Button button=new Button(this);

                    // Configuración básica para ambos tipos de botón
                    button.setLayoutParams(new android.widget.GridLayout.LayoutParams());
                    button.getLayoutParams().width = buttonSize;
                    button.getLayoutParams().height = buttonSize;

                    // Guardar el botón en el array de View
                    buttons[i][e] = button;

                    // Configurar comportamiento al hacer clic
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Acción al hacer clic en la casilla
                            if (v instanceof ImageButton) {
                                // Acciones para la mina
                            } else if (v instanceof Button) {
                                // Acciones para una casilla normal
                            }
                        }
                    });

                    // Añadir el botón al GridLayout
                    gridLayout.addView(button);
                }
            }
        }
    }

}