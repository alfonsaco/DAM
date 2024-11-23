package edu.pruebas.sharemybike;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnUbi;
    private Button btnLogin;
    private TextView txtCodPostal;
    private FusedLocationProviderClient fusedLocationClient;
    private boolean login = false;

    private double lastLatitude = 0.0;
    private double lastLongitude = 0.0;

    private ActivityResultLauncher<String[]> locationPermissionRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUbi = findViewById(R.id.btnUbi);
        btnLogin = findViewById(R.id.btnLogin);
        txtCodPostal = findViewById(R.id.txtCodPostal);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Registra el lanzador de permisos
        locationPermissionRequest = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(),
                result -> {
                    Boolean fineLocationGranted = result.get(Manifest.permission.ACCESS_FINE_LOCATION);
                    Boolean coarseLocationGranted = result.get(Manifest.permission.ACCESS_COARSE_LOCATION);

                    if (fineLocationGranted != null && fineLocationGranted) {
                        // Permiso otorgado, obtenemos la ubicación
                        getCurrentLocation();
                    } else if (coarseLocationGranted != null && coarseLocationGranted) {
                        Toast.makeText(this, "Permiso de ubicación aproximada otorgado", Toast.LENGTH_SHORT).show();
                        getCurrentLocation(); // Usa coarse location si fine location no está disponible
                    } else {
                        Toast.makeText(this, "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnUbi.setOnClickListener(view -> {
            // Solicitar permisos de ubicación
            requestLocationPermission();
        });

        btnLogin.setOnClickListener(view -> {
            if (!login) {
                Toast.makeText(MainActivity.this, "Primero debes obtener la ubicación", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestLocationPermission() {
        locationPermissionRequest.launch(new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });
    }

    private void getCurrentLocation() {
        // Verificar si el permiso de ubicación ha sido otorgado
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(location -> {
                        if (location != null) {
                            lastLatitude = location.getLatitude();
                            lastLongitude = location.getLongitude();

                            // Abrir Google Maps con la ubicación actual
                            openGoogleMaps(lastLatitude, lastLongitude);

                            login = true; // Marcar como listo para login
                        } else {
                            Toast.makeText(this, "No se pudo obtener la ubicación", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Toast.makeText(this, "Permiso de ubicación no otorgado", Toast.LENGTH_SHORT).show();
        }
    }

    private void openGoogleMaps(double latitude, double longitude) {
        String geoUri = "geo:0,0?q=" + latitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse(geoUri));
        startActivity(intent); // Lanza directamente el Intent
    }

    private void getPostalAddress(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && !addresses.isEmpty()) {
                String postalAddress = addresses.get(0).getAddressLine(0);
                txtCodPostal.setText(postalAddress);
            } else {
                txtCodPostal.setText("Dirección postal no disponible");
            }
        } catch (IOException e) {
            e.printStackTrace();
            txtCodPostal.setText("Error al obtener la dirección");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Obtener la dirección postal al volver a la app
        if (lastLatitude != 0.0 && lastLongitude != 0.0) {
            getPostalAddress(lastLatitude, lastLongitude);
        }
    }
}
