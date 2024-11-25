package edu.pruebas.notificaciones;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    Button btnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnNotificacion=findViewById(R.id.btnNotificacion);

        // Crear el canal de notificaciones
        crearCanalNotificaciones();

        // Enviar la notificación
        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarNotificacion("Has recibico una notificación", "Haz Click para abrir la actividad");
            }
        });
    }

    // Método para crear un canal de notificaciones para poder grstionarlas
    private void crearCanalNotificaciones() {
        // Compatibilidad
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Creación del canal y sus datos
            NotificationChannel canal=new NotificationChannel(
                    "miCanal",
                    "Canal de Notificaciones",
                    NotificationManager.IMPORTANCE_HIGH
            );
            canal.setDescription("Canal de notificaciones para pruebas");

            // Sistema que maneja las notificaciones
            NotificationManager gestorNotificaciones=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (gestorNotificaciones != null) {
                gestorNotificaciones.createNotificationChannel(canal);
            }
        }
    }

    // Método para enviar la notificación
    private void enviarNotificacion(String titulo, String contenido) {
        // Crear un Intent para abrir la actividad cuando se toque la notificación
        Intent intent = new Intent(this, SecondActivity.class);

        int pendingIntentFlags = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ?
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE :
                PendingIntent.FLAG_UPDATE_CURRENT;

        // Pending para el Intent
        PendingIntent pendingIntent=PendingIntent.getActivity(this,
                0, intent, pendingIntentFlags);

        // Crear la notificación
        NotificationCompat.Builder constructorNotificacion=new NotificationCompat.Builder(this, "miCanal")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(titulo)
                .setContentText(contenido)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // Mostrar la notificación
        NotificationManager gestorNotificaciones=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (gestorNotificaciones != null) {
            gestorNotificaciones.notify(1, constructorNotificacion.build());
        }
    }
}
