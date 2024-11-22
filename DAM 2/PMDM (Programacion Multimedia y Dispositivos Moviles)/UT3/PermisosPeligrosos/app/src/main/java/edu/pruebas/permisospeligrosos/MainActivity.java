package edu.pruebas.permisospeligrosos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    
    private TextView txtUbicacion;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUbicacion = findViewById(R.id.txtUbicacion);

        // Verificar permisos de ubicación
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            iniciarProcesoUbicacion();

        } else {
            solicitarPermisos();
        }
    }

    private void solicitarPermisos() {
        // Solo pedimos permisos si son necesarios y en el caso de que Android tenga versión 6.0 o superior
        // ya que de lo contrario, me daba errores
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    private void iniciarProcesoUbicacion() {
        try {
            // Inicializamos el administrador de ubicación
            locationManager=(LocationManager) getSystemService(LOCATION_SERVICE);

            // Verificar si el GPS está habilitado
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                // Solicitamos una única actualización de ubicación
                locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, new LocationListener() {
                    @Override
                    public void onLocationChanged(@NonNull Location location) {
                        // Obtenemos las coordenadas
                        double latitud=location.getLatitude();
                        double longitud=location.getLongitude();

                        // Mostrar coordenadas
                        txtUbicacion.setText("Latitud: " + latitud + "\nLongitud: " + longitud);
                    }
                }, null);
            } else {
                Toast.makeText(this, "El GPS está desactivado. Por favor, actívalo para continuar.", Toast.LENGTH_LONG).show();
            }

        } catch (SecurityException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al acceder a la ubicación.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            // Permiso aceptado
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                iniciarProcesoUbicacion();

            } else {
                txtUbicacion.setText("No se concedió el permiso. No es posible obtener la ubicación.");
            }
        }
    }
}
