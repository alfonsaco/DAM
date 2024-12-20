package edu.pruebas.gestorcontactos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CONTACTS = 100;

    Button btnAcceder;
    Button btnAgregar;
    Button btnBluetooth;
    LinearLayout linearLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnAcceder=findViewById(R.id.btnAcceder);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnBluetooth=findViewById(R.id.btnBluetooth);
        linearLayout=findViewById(R.id.linearLayout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Al pulsar en acceder, mostrará los contactos
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndRequestPermissions();
            }
        });
    }

    private void checkAndRequestPermissions() {
        // Verifica si ya se tienen los permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            // Solicita los permisos al usuario
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_CONTACTS
            }, PERMISSION_REQUEST_CONTACTS);
        } else {
            // Los permisos ya están concedidos, realizar acción para acceder a los contactos
            accessContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, acceder a los contactos
                accessContacts();
            } else {

            }
        }
    }

    // Poner los contactos dentro del ScrollView
    private void accessContacts() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // Usa un HashSet para evitar que se dupliquen los contactos
        Set<String> contactIds = new HashSet<>();

        // Obtén los contactos del dispositivo
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        );

        if (cursor != null) {
            linearLayout.removeAllViews(); // Limpia el LinearLayout antes de agregar los contactos

            while (cursor.moveToNext()) {
                // Obtén el ID del contacto
                String contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

                // Si el contacto ya ha sido procesado, continúa con el siguiente
                if (contactIds.contains(contactId)) {
                    continue;
                }

                // Agrega el ID al HashSet para evitar duplicados
                contactIds.add(contactId);

                // Obtén el nombre y el número de teléfono
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                // Crea un TextView para mostrar el contacto
                TextView contactView = new TextView(this);
                contactView.setText(name + "\n" + phone + "\n\n");
                contactView.setTextSize(16); // Opcional: ajustar tamaño del texto
                contactView.setPadding(16, 16, 16, 16); // Opcional: agregar padding
                contactView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

                contactView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        showEditContactDialog(contactId, name, phone);
                        return true;
                    }
                });

                // Agrega el TextView al LinearLayout
                linearLayout.addView(contactView);
            }

            cursor.close();
        }
    }


    private void showEditContactDialog(String contactId, String currentName, String currentPhone) {
        // Inflar el diseño del diálogo
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_editar_contacto, null);
        EditText editName = dialogView.findViewById(R.id.editTextText);
        EditText editPhone = dialogView.findViewById(R.id.editTextText2);

        // Establecer valores iniciales
        editName.setText(currentName);
        editPhone.setText(currentPhone);

        // Crear el diálogo
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create();

        dialogView.findViewById(R.id.btnCancelar).setOnClickListener(v -> dialog.dismiss());

        dialogView.findViewById(R.id.btnGuardar).setOnClickListener(v -> {
            String newName = editName.getText().toString();
            String newPhone = editPhone.getText().toString();

            if (!newName.isEmpty() && !newPhone.isEmpty()) {
                updateContact(contactId, newName, newPhone);
                dialog.dismiss();
            } else {
                Toast.makeText(this, "Por favor, completa ambos campos.", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    private void updateContact(String contactId, String newName, String newPhone) {
        ContentValues values = new ContentValues();

        // Actualizar el nombre
        values.put(ContactsContract.Data.DISPLAY_NAME, newName);
        getContentResolver().update(
                ContactsContract.Data.CONTENT_URI,
                values,
                ContactsContract.Data.CONTACT_ID + " = ? AND " +
                        ContactsContract.Data.MIMETYPE + " = ?",
                new String[]{contactId, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE}
        );

        // Actualizar el número de teléfono
        values.clear();
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, newPhone);
        getContentResolver().update(
                ContactsContract.Data.CONTENT_URI,
                values,
                ContactsContract.Data.CONTACT_ID + " = ? AND " +
                        ContactsContract.Data.MIMETYPE + " = ?",
                new String[]{contactId, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE}
        );

        Toast.makeText(this, "Contacto actualizado.", Toast.LENGTH_SHORT).show();
        accessContacts(); // Refrescar la lista de contactos
    }
}