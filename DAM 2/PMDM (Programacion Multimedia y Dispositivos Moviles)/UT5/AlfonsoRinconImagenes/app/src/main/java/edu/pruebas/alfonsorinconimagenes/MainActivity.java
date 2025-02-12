package edu.pruebas.alfonsorinconimagenes;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;

    private Button btnGrabarImagen, btnEscalaGrises, btnInvertir, btnRecortar, btnRotar, btnGuardarImagen;
    private Button btnGrabarVideo, btnVelocidadMedia, btnVelocidadNormal, btnPorDos;
    private ImageView imageView;
    private VideoView videoView;
    private SeekBar seekBarBrillo;

    private Bitmap currentBitmap;
    private Uri currentVideoUri;
    private MediaPlayer mediaPlayer;

    // Launcher para capturar imagen usando TakePicturePreview para obtener el bitmap
    private ActivityResultLauncher<Void> capturaImagenLauncher = registerForActivityResult(
            new ActivityResultContracts.TakePicturePreview(),
            new ActivityResultCallback<Bitmap>() {
                @Override
                public void onActivityResult(Bitmap resultado) {
                    if (resultado != null) {
                        currentBitmap = resultado;
                        imageView.setImageBitmap(currentBitmap);
                    } else {
                        Toast.makeText(MainActivity.this, "No se capturó la imagen", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    // Launcher para grabar video
    private ActivityResultLauncher<Intent> capturaVideoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri videoUri = result.getData().getData();
                    if (videoUri != null) {
                        currentVideoUri = videoUri;
                        videoView.setVideoURI(videoUri);
                        videoView.start();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrabarImagen= findViewById(R.id.btnGrabarImagen);
        imageView= findViewById(R.id.imageView);
        btnEscalaGrises= findViewById(R.id.btnEscalaGrises);
        btnInvertir= findViewById(R.id.btnInvertir);
        btnRecortar = findViewById(R.id.btnRecortar);
        btnRotar = findViewById(R.id.btnRotar);
        seekBarBrillo= findViewById(R.id.seekBarBrillo);
        btnGuardarImagen= findViewById(R.id.btnGuardarImagen);
        btnGrabarVideo= findViewById(R.id.btnGrabarVideo);
        videoView= findViewById(R.id.videoView);
        btnVelocidadMedia= findViewById(R.id.btnVelocidadMedia);
        btnVelocidadNormal = findViewById(R.id.btnVelocidadNormal);
        btnPorDos= findViewById(R.id.btnPorDos);

        // Capturar imagen: verificamos y solicitamos el permiso de cámara
        btnGrabarImagen.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_GRANTED) {
                capturaImagenLauncher.launch(null);
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        CAMERA_PERMISSION_REQUEST_CODE);
            }
        });

        // Aplicar escala de grises
        btnEscalaGrises.setOnClickListener(v -> {
            if (currentBitmap != null) {
                currentBitmap = aplicarEscalaGrises(currentBitmap);
                imageView.setImageBitmap(currentBitmap);
            }
        });

        // Invertir colores
        btnInvertir.setOnClickListener(v -> {
            if (currentBitmap != null) {
                currentBitmap = aplicarInvertir(currentBitmap);
                imageView.setImageBitmap(currentBitmap);
            }
        });

        // Recortar imagen
        btnRecortar.setOnClickListener(v -> {
            if (currentBitmap != null) {
                currentBitmap = recortarBitmap(currentBitmap);
                imageView.setImageBitmap(currentBitmap);
            }
        });

        // Rotar imagen
        btnRotar.setOnClickListener(v -> {
            if (currentBitmap != null) {
                currentBitmap = rotarBitmap(currentBitmap, 90f);
                imageView.setImageBitmap(currentBitmap);
            }
        });

        // Ajustar brillo mediante SeekBar
        seekBarBrillo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean fromUser) {
                if (currentBitmap != null) {
                    // CSe convierte a un valor de brillo entre -100 y 100
                    float brillo = progreso - 100;
                    Bitmap ajustado = ajustarBrillo(currentBitmap, brillo);
                    imageView.setImageBitmap(ajustado);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Guardar imagen editada en la galería
        btnGuardarImagen.setOnClickListener(v -> {
            if (currentBitmap != null) {
                guardarImagen(currentBitmap);
            }
        });

        // Grabar video usando el launcher
        btnGrabarVideo.setOnClickListener(v -> {
            Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            capturaVideoLauncher.launch(videoIntent);
        });

        // Ajustar velocidad de reproducción del video
        btnVelocidadMedia.setOnClickListener(v -> ajustarVelocidadReproduccion(0.5f));
        btnVelocidadNormal.setOnClickListener(v -> ajustarVelocidadReproduccion(1.0f));
        btnPorDos.setOnClickListener(v -> ajustarVelocidadReproduccion(2.0f));

        // Cuando el VideoView esté preparado, obtenemos el MediaPlayer
        videoView.setOnPreparedListener(mp -> mediaPlayer = mp);
    }

    // Manejo de la respuesta del permiso de cámara
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                capturaImagenLauncher.launch(null);
            } else {
                Toast.makeText(this, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    // Método para aplicar escala de grises usando ColorMatrix
    private Bitmap aplicarEscalaGrises(Bitmap src) {
        Bitmap bmp = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint pincel = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        pincel.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(src, 0, 0, pincel);
        return bmp;
    }

    // Método para invertir colores usando ColorMatrix
    private Bitmap aplicarInvertir(Bitmap src) {
        Bitmap bmp = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        Canvas canvas = new Canvas(bmp);
        Paint pincel = new Paint();
        ColorMatrix cm = new ColorMatrix(new float[]{
                -1.0f, 0, 0, 0, 255,
                0, -1.0f, 0, 0, 255,
                0, 0, -1.0f, 0, 255,
                0, 0, 0, 1.0f, 0
        });
        pincel.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(src, 0, 0, pincel);
        return bmp;
    }

    // Método para recortar la imagen (se recorta la parte central)
    private Bitmap recortarBitmap(Bitmap src) {
        int ancho = src.getWidth();
        int alto = src.getHeight();
        return Bitmap.createBitmap(src, ancho / 4, alto / 4, ancho / 2, alto / 2);
    }

    // Método para rotar la imagen
    private Bitmap rotarBitmap(Bitmap src, float angulo) {
        Matrix matriz = new Matrix();
        matriz.postRotate(angulo);
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matriz, true);
    }

    // Método para ajustar el brillo usando ColorMatrix
    private Bitmap ajustarBrillo(Bitmap src, float brillo) {
        Bitmap bmp = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        Canvas canvas = new Canvas(bmp);
        Paint pincel = new Paint();
        ColorMatrix cm = new ColorMatrix(new float[]{
                1, 0, 0, 0, brillo,
                0, 1, 0, 0, brillo,
                0, 0, 1, 0, brillo,
                0, 0, 0, 1, 0
        });
        pincel.setColorFilter(new ColorMatrixColorFilter(cm));
        canvas.drawBitmap(src, 0, 0, pincel);
        return bmp;
    }

    // Método para guardar la imagen en la galería
    private void guardarImagen(Bitmap bitmap) {
        String urlGuardado = MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                "imagen_editada",
                "Imagen editada desde la app"
        );
        Toast.makeText(this, "Imagen guardada: " + urlGuardado, Toast.LENGTH_SHORT).show();
    }

    // Método para ajustar la velocidad de reproducción del video usando PlaybackParams
    private void ajustarVelocidadReproduccion(float velocidad) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && mediaPlayer != null) {
            try {
                PlaybackParams params = mediaPlayer.getPlaybackParams();
                params.setSpeed(velocidad);
                mediaPlayer.setPlaybackParams(params);
                Toast.makeText(this, "Velocidad: " + velocidad + "x", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al ajustar velocidad", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "El ajuste de velocidad no es compatible en este dispositivo", Toast.LENGTH_SHORT).show();
        }
    }
}
