package edu.pruebas.gestorcontactos;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.bluetooth.BluetoothAdapter;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.Manifest;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CONTACTS = 100;
    private ActivityResultLauncher<Intent> bluetoothLauncher;

    Button btnAcceder;
    Button btnAgregar;
    Button btnBluetooth;
    Button btnGuardarContacto;
    EditText etxtNombre;
    EditText etxtTelefono;
    LinearLayout linearLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnAcceder = findViewById(R.id.btnAcceder);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnBluetooth = findViewById(R.id.btnBluetooth);
        linearLayout = findViewById(R.id.linearLayout);
        btnGuardarContacto = findViewById(R.id.btnGuardarContacto);
        etxtNombre = findViewById(R.id.etxtNombre);
        etxtTelefono = findViewById(R.id.etxtTelefono);

        // Launcher del Bluetooth
        bluetoothLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Toast.makeText(this, "Bluetooth activado.", Toast.LENGTH_SHORT).show();
                        listarDispositivosBluetooth();
                    } else {
                        Toast.makeText(this, "Bluetooth no activado.", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etxtNombre.setVisibility(View.INVISIBLE);
        etxtTelefono.setVisibility(View.INVISIBLE);
        btnGuardarContacto.setVisibility(View.INVISIBLE);

        // Al pulsar en acceder, mostrará los contactos
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permisosContactos();
            }
        });

        // Al pulsar el botón de "Activar Bluetooth", nos pide permisos
        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedirPermisosBluetooth();
            }
        });

        // Mostrar la casilla para agregar un contacto
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etxtNombre.setVisibility(View.VISIBLE);
                etxtTelefono.setVisibility(View.VISIBLE);
                btnGuardarContacto.setVisibility(View.VISIBLE);
            }
        });

        // Se guarda el nuevo contacto
        btnGuardarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etxtNombre.getText().toString();
                String telefono = etxtTelefono.getText().toString();

                // Verificamos que no esté vacío y que el número de teléfono sea válido
                if (!nombre.isEmpty() && !telefono.isEmpty()) {
                    if(esTelefono(telefono)) {
                        guardarContacto(nombre, telefono);
                        etxtNombre.setText("");
                        etxtTelefono.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Número no válido", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Por favor, completa ambos campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para verificar que el texto sea un teléfono
    private boolean esTelefono(String tel) {
        return tel.matches("^\\+?[0-9\\- ]+$");
    }

    // Método para pedir permisos
    private void permisosContactos() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            // Si no los tiene, solicita los permisos al usuario
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_CONTACTS
            }, PERMISSION_REQUEST_CONTACTS);

        } else {
            mostrarContactos();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                listarDispositivosBluetooth();

            } else {
                Toast.makeText(this, "Permiso de Bluetooth denegado.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Poner los contactos dentro del ScrollView
    private void mostrarContactos() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // Usamos un HashSet para evitar que se dupliquen los contactos
        Set<String> IDcontactos = new HashSet<>();

        // Obtenemos los contactos del dispositivo
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        );

        if (cursor != null) {
            linearLayout.removeAllViews();

            while (cursor.moveToNext()) {
                // ID del contacto
                String ID = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));

                // Verificamos que el contacto no esté  en el set, para evitar que haya duplicados
                if (IDcontactos.contains(ID)) {
                    continue;
                }
                IDcontactos.add(ID);

                String nombre = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String telefono = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                TextView contactView = new TextView(this);
                contactView.setText(nombre + "\n" + telefono + "\n");
                contactView.setTextSize(16);
                // Padding para mejorar aspecto
                contactView.setPadding(16, 16, 16, 16);
                contactView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

                // Evento de Click. Se permite editar la información
                contactView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mostrarDialogoEditarContacto(ID, nombre, telefono);
                    }
                });

                // Evento longClick. Permite enviar un VCARD
                contactView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        // Verificar si el Bluetooth está conectado
                        if (!bluetoothEstaConectado()) {
                            Toast.makeText(MainActivity.this, "El Bluetooth no está conectado.", Toast.LENGTH_SHORT).show();
                            return true;
                        }

                        // Verificar permisos para acceder a dispositivos Bluetooth
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                            // Si no se tiene permiso, solicita al usuario
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 1);
                            return true;
                        }

                        // Obtiene los dispositivos emparejados
                        Set<BluetoothDevice> dispositivosEmparejados = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
                        if (dispositivosEmparejados.isEmpty()) {
                            Toast.makeText(MainActivity.this, "No hay dispositivos Bluetooth emparejados.", Toast.LENGTH_SHORT).show();
                            return true;
                        }

                        // Selecciona un dispositivo (modifica según tu lógica)
                        BluetoothDevice dispositivoSeleccionado = dispositivosEmparejados.iterator().next();

                        // Mostrar el diálogo con los datos del contacto
                        mostrarDialogoEnviarContacto(nombre, telefono, dispositivoSeleccionado);

                        return true;
                    }
                });

                // Agrega el TextView al LinearLayout
                linearLayout.addView(contactView);
            }

            cursor.close();
        }
    }

    // Muestra el diálogo para enivar el contacto al dispositivo Bluetooth
    private void mostrarDialogoEnviarContacto(String nombre, String telefono, BluetoothDevice dispositivo) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_enviar, null);
        TextView txtContactoEnviar = dialogView.findViewById(R.id.txtModificar);
        Button btnAceptar = dialogView.findViewById(R.id.btnAceptar);

        // Contenido en el diálogo
        String vCard = "BEGIN:VCARD\n" +
                "VERSION:3.0\n" +
                "FN:" + nombre + "\n" +
                "TEL:" + telefono + "\n" +
                "END:VCARD";

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        txtContactoEnviar.setText("Contacto enviado al \"" + dispositivo.getName() + "\":\n" + vCard);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create();

        // Al pulsar en aceptar, se cierra el diálogo y se envia el VCARD
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                enviarContactoComoVCard(nombre, telefono, dispositivo);
            }
        });

        dialog.show();
    }

    // Método para verificar si el Bluetooth está habilitado
    private boolean bluetoothEstaConectado() {
        try {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            // Caso en el que el dispositivo no tiene bluetooth
            if (bluetoothAdapter == null) {
                return false;
            }
            return bluetoothAdapter.isEnabled();

        } catch (Exception e) {
            return false;
        }
    }

    // Método para mostrar el diálogo que permite editar un contacto
    private void mostrarDialogoEditarContacto(String id, String nombreActual, String telefonoActual) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_editar_contacto, null);
        EditText etxtNombre = dialogView.findViewById(R.id.editTextText);
        EditText etxtTelefono = dialogView.findViewById(R.id.editTextText2);

        etxtNombre.setText(nombreActual);
        etxtTelefono.setText(telefonoActual);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
                .create();

        dialogView.findViewById(R.id.btnCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialogView.findViewById(R.id.btnGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = etxtNombre.getText().toString();
                String newPhone = etxtTelefono.getText().toString();

                if (!newName.isEmpty() && !newPhone.isEmpty()) {
                    actualizarContacto(id, newName, newPhone);
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, completa ambos campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    private void actualizarContacto(String contactId, String newName, String newPhone) {
        ContentValues values = new ContentValues();

        // Actualizar el nombre
        values.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, newName);
        int nameUpdate = getContentResolver().update(
                ContactsContract.Data.CONTENT_URI,
                values,
                ContactsContract.Data.CONTACT_ID + " = ? AND " +
                        ContactsContract.Data.MIMETYPE + " = ?",
                new String[]{contactId, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE}
        );

        // Actualizar el número de teléfono
        values.clear();
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, newPhone);
        int phoneUpdate = getContentResolver().update(
                ContactsContract.Data.CONTENT_URI,
                values,
                ContactsContract.Data.CONTACT_ID + " = ? AND " +
                        ContactsContract.Data.MIMETYPE + " = ?",
                new String[]{contactId, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE}
        );

        if (nameUpdate > 0 || phoneUpdate > 0) {
            Toast.makeText(this, "Contacto actualizado.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al actualizar el contacto.", Toast.LENGTH_SHORT).show();
        }

        mostrarContactos(); // Refrescar la lista de contactos
    }

    // Método para pedir los permisos de bluetooth
    private void pedirPermisosBluetooth() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Caso en el que el dispositivo no tiene bluetooth
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth no es compatible con este dispositivo.", Toast.LENGTH_SHORT).show();
            return;
        }

        // El bluetooth no está activo
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            bluetoothLauncher.launch(enableBtIntent);

        } else {
            Toast.makeText(this, "El Bluetooth ya está activado.", Toast.LENGTH_SHORT).show();
            listarDispositivosBluetooth();
        }
    }

    private void listarDispositivosBluetooth() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth no es compatible con este dispositivo.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "El Bluetooth no está activado.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Limpia el LinearLayout
        linearLayout.removeAllViews();

        // Obtiene los dispositivos emparejados
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Set<BluetoothDevice> dispositivosEmparejados = bluetoothAdapter.getBondedDevices();

        if (dispositivosEmparejados.isEmpty()) {
            Toast.makeText(this, "No hay dispositivos Bluetooth emparejados.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Se muestran todos los dispositivos detectados
        for (BluetoothDevice dispositivo : dispositivosEmparejados) {
            String nombreDispositivo = dispositivo.getName();
            String direccionDispositivo = dispositivo.getAddress(); // Dirección MAC del dispositivo

            // TextView para mostrar el dispositivo
            TextView dispositivoView = new TextView(this);
            dispositivoView.setText(nombreDispositivo + " (" + direccionDispositivo + ")");
            dispositivoView.setTextSize(16);
            dispositivoView.setPadding(16, 16, 16, 16);
            dispositivoView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            // Mostrar un Toast al seleccionar el dispositivo
            dispositivoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Seleccionaste: " + nombreDispositivo, Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(dispositivoView);
        }
    }

    // Método para guardar el nuevo contacto creado
    private void guardarContacto(String nombre, String telefono) {
        ContentValues values = new ContentValues();

        // Insertar un nuevo contacto
        values.put(ContactsContract.RawContacts.ACCOUNT_TYPE, (String) null);
        values.put(ContactsContract.RawContacts.ACCOUNT_NAME, (String) null);
        long rawContactId = ContentUris.parseId(getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values));

        // Insertar el nombre del contacto
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, nombre);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

        // Insertar el número de teléfono del contacto
        values.clear();
        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, telefono);
        values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

        Toast.makeText(this, "Contacto \""+nombre+"\" añadido", Toast.LENGTH_SHORT).show();
        mostrarContactos();
    }

    // Método para enviar el contacto como VCard
    private void enviarContactoComoVCard(String nombre, String telefono, BluetoothDevice dispositivo) {
        try {
            // Contenido de la VCard
            String vCard = "BEGIN:VCARD\n" +
                    "VERSION:3.0\n" +
                    "FN:" + nombre + "\n" +
                    "TEL:" + telefono + "\n" +
                    "END:VCARD";

            File vCardFile = new File(getCacheDir(), "contacto.vcf");
            try (FileWriter writer = new FileWriter(vCardFile)) {
                writer.write(vCard);
            }

            // Intent para enviar el archivo
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/x-vcard");
            Uri fileUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", vCardFile);
            sendIntent.putExtra(Intent.EXTRA_STREAM, fileUri);

            // Se configura el dispositivo de destino
            sendIntent.putExtra("android.bluetooth.device.extra.DEVICE", dispositivo);
            startActivity(Intent.createChooser(sendIntent, "Enviar contacto a través de:"));

        } catch (IOException e) {
            Toast.makeText(this, "Error al crear la VCard: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}