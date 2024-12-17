package edu.pmdm.alfonsorinconsms;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageButton btnBuscarNombre;
    ImageButton btnBuscarApellido;
    Button btnSeleccionar;
    EditText etxtNombre;
    EditText etxtApellido;
    ScrollView scrollContactos;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnBuscarNombre = findViewById(R.id.btnBuscarNombre);
        btnBuscarApellido = findViewById(R.id.btnBuscarApellido);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);
        etxtNombre = findViewById(R.id.etxtNombre);
        etxtApellido = findViewById(R.id.etxtApellido);
        scrollContactos = findViewById(R.id.scrollContactos);
        linearLayout = findViewById(R.id.linearLayout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etxtApellido.setVisibility(View.INVISIBLE);
        etxtNombre.setVisibility(View.INVISIBLE);
        btnBuscarApellido.setVisibility(View.INVISIBLE);
        btnBuscarNombre.setVisibility(View.INVISIBLE);
        scrollContactos.setVisibility(View.INVISIBLE);

        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etxtApellido.setVisibility(View.VISIBLE);
                etxtNombre.setVisibility(View.VISIBLE);
                btnBuscarApellido.setVisibility(View.VISIBLE);
                btnBuscarNombre.setVisibility(View.VISIBLE);
                scrollContactos.setVisibility(View.VISIBLE);

                // Solicitar permisos y cargar contactos
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 1);
                    } else {
                        cargarContactos();
                    }
                }
            }
        });

        btnBuscarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = etxtNombre.getText().toString().trim();
                if (!texto.isEmpty()) {
                    buscarContactosPorPatron(texto);
                }
            }
        });

        btnBuscarApellido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = etxtApellido.getText().toString().trim();
                if (!texto.isEmpty()) {
                    buscarContactosPorPatron(texto);
                }
            }
        });
    }

    private void cargarContactos() {
        Log.d("MainActivity", "Cargando contactos...");
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));


                TextView contactoView = new TextView(this);
                contactoView.setText(nombre);
                contactoView.setTextSize(18);
                contactoView.setPadding(16, 16, 16, 16);
                linearLayout.addView(contactoView);
            }
            cursor.close();
        } else {
            Log.d("MainActivity", "No se encontraron contactos.");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            cargarContactos();
        }
    }

    private void buscarContactosPorPatron(String patron) {
        // Limpiar los resultados previos
        linearLayout.removeAllViews();

        // Reemplazar '#' por '%', que es el comodín en SQL
        String queryPatron = patron.replace("#", "%");

        ContentResolver resolver = getContentResolver();
        String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " LIKE ?";
        String[] selectionArgs = { queryPatron };

        Cursor cursor = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                selection,
                selectionArgs,
                null
        );

        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String nombreCompleto = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String telefono = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                TextView contactoView = new TextView(this);
                contactoView.setText(nombreCompleto + " - " + telefono);
                contactoView.setTextSize(18);
                contactoView.setPadding(16, 16, 16, 16);
                linearLayout.addView(contactoView);
            }
            cursor.close();
        } else {
            Log.d("MainActivity", "No se encontraron contactos con el patrón: " + patron);
        }
    }

}
