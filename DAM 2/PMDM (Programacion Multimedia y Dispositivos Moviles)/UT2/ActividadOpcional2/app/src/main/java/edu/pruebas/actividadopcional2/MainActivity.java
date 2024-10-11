package edu.pruebas.actividadopcional2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText etxtNombre;
    EditText etxtApellidos;
    EditText etxtFecha;
    EditText etxtNumHijos;
    EditText etxtSalarioBruto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCalcular=findViewById(R.id.btnCalcular);
        etxtNombre=findViewById(R.id.etxtNombre);
        etxtApellidos=findViewById(R.id.etxtApellidos);
        etxtFecha=findViewById(R.id.etxtFecha);
        etxtNumHijos=findViewById(R.id.etxtNumHijos);
        etxtSalarioBruto=findViewById(R.id.etxtSalarioBruto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Intent
        Intent intent=new Intent(this, ResultadoActivity.class);

        // Obtener la fecha
        Calendar calendar=Calendar.getInstance();
        int dia=calendar.get(Calendar.DAY_OF_MONTH);
        int mes=calendar.get(Calendar.MONTH);
        int año=calendar.get(Calendar.YEAR);
        etxtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        (view1, añoSeleccionado, mesSeleccionado, diaSeleccionado) -> {
                            mesSeleccionado = mesSeleccionado + 1;
                            String formattedDate = String.format("%02d/%02d/%04d", diaSeleccionado, mesSeleccionado, añoSeleccionado);
                            etxtFecha.setText(formattedDate);
                        },
                        año,
                        mes,
                        dia
                );
                datePickerDialog.show();
            }
        });

        // Al pulsar el botón, nos llevará a la siguiente pantalla, que tendrá el resultado
        //if(!etxtApellidos.getText().toString().isEmpty() && !etxtNombre.getText().toString().isEmpty() && !etxtNumHijos.getText().toString().isEmpty() && !etxtSalarioBruto.getText().toString().isEmpty()) {
            btnCalcular.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    // Variables
                    String nombre=String.valueOf(etxtNombre.getText());
                    String apellidos=String.valueOf(etxtApellidos.getText());

                    // Cálculos de deducciones
                    double salarioBruto=Integer.parseInt(String.valueOf(etxtSalarioBruto.getText()));
                    double baseImponible=baseImponible(salarioBruto);

                    // Cálculo del mínimo familiar
                    int hijos= Integer.parseInt(String.valueOf(etxtNumHijos.getText()));
                    int edad=calcularEdad(año);
                    // Métodos
                    int minimoHijos=calcularMinimoHijos(hijos);
                    int minimoPersonal=calcularMinimoPersonal(edad);
                    int totalMinimoFamiliar=minimoHijos + minimoPersonal;

                    // IRPF Progresivo
                    double IRPFbaseImponible=calcularIRPFtramos(baseImponible);
                    double IRPFfamiliar=calcularIRPFfamiliar(totalMinimoFamiliar);

                    // IRP final
                    double IRPFfinal=IRPFbaseImponible - IRPFfamiliar;

                    // Asignar elementos para el Intent
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellidos", apellidos);
                    intent.putExtra("irpf", IRPFfinal);

                    startActivity(intent);
                }
            });
        //}
    }

    // Método para calcular el IRPF familiar por tramos
    private double calcularIRPFfamiliar(double totalMinimoFamiliar) {
        double total=totalMinimoFamiliar * 0.19;

        return total;
    }

    // Método para calcular el IRPF por tramos
    private double calcularIRPFtramos(double baseImponible) {
        double restante=baseImponible;
        double total=0;

        if(restante > 0) {
            total=12450 * 0.19;
            restante-=12450;
        } else {
            return baseImponible * 0.19;
        }

        if(restante > 0) {
            total+=(7750 * 0.24);
            restante-=7750;
        } else {
            return total + (7750 * 0.24);
        }

        if(restante > 0) {
            total+=5895 * 0.3;
            restante-=5895;
        } else {
            return total + (5895 * 0.3);
        }

        if (restante > 0) {
            total += restante * 0.37;
        }

        return total;
    }

    // Método para calcular la edad
    private int calcularEdad(int año) {
        Calendar calendar=Calendar.getInstance();
        int añoActual=calendar.get(Calendar.YEAR);
        int edad=añoActual - año;

        return edad;
    }

    // Método para calcular el mínimo personal
    private int calcularMinimoPersonal(int edad) {
        int minimoPersonal=0;

        if(edad < 65 && edad > 0) {
            minimoPersonal=5550;
        } else if(edad > 65 && edad < 75) {
            minimoPersonal=6468;
        } else if(edad > 75) {
            minimoPersonal=7590;
        }

        return minimoPersonal;
    }

    // Método para calcular la base imponible
    private double baseImponible(double salarioBruto) {
        // Cálculos
        double seguridadSocial=salarioBruto * 0.0635;
        double baseImponible=salarioBruto - 2000 - seguridadSocial;

        return baseImponible;
    }

    // Método para calcular el mínimo por descendientes
    private int calcularMinimoHijos(int hijos) {
        int minimoDescendientes=0;

        if(hijos == 0) {
            minimoDescendientes=0;
        } else if(hijos == 1) {
            minimoDescendientes=2400;
        } else if(hijos == 2) {
            minimoDescendientes=2400 + 2700;
        } else if(hijos == 3) {
            minimoDescendientes=2400 + 2700 + 4000;
        } else if(hijos >= 4) {
            minimoDescendientes=2400 + 2700 + 4000 + 4500;
        }

        return minimoDescendientes;
    }
}