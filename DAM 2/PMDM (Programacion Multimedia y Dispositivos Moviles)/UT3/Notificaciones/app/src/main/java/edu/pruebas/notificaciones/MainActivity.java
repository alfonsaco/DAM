package edu.pruebas.notificaciones;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    Button btnNotificacion;
    private static final String CANAL_ID = "miCanal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnNotificacion = findViewById(R.id.btnNotificacion);

        // Crear el canal de notificaciones
        crearCanalNotificaciones();

        // Listener para enviar la notificación
        btnNotificacion.setOnClickListener(view -> enviarNotificacion("Recibiste una notificación", "Haz clic para abrir una actividad"));
    }

    private void crearCanalNotificaciones() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal = new NotificationChannel(
                    CANAL_ID,
                    "Canal de Notificaciones",
                    NotificationManager.IMPORTANCE_HIGH
            );
            canal.setDescription("Canal de notificaciones para pruebas");
            NotificationManager gestorNotificaciones = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (gestorNotificaciones != null) {
                gestorNotificaciones.createNotificationChannel(canal);
            }
        }
    }

    private void enviarNotificacion(String titulo, String contenido) {
        // Crear un Intent para abrir la actividad cuando se toque la notificación
        Intent intent = new Intent(this, SecondActivity.class);

        int pendingIntentFlags = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ?
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE :
                PendingIntent.FLAG_UPDATE_CURRENT;

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                pendingIntentFlags
        );

        // Crear la notificación
        NotificationCompat.Builder constructorNotificacion = new NotificationCompat.Builder(this, CANAL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(titulo)
                .setContentText(contenido)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // Mostrar la notificación
        NotificationManager gestorNotificaciones = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (gestorNotificaciones != null) {
            gestorNotificaciones.notify(1, constructorNotificacion.build());
        }
    }
}
