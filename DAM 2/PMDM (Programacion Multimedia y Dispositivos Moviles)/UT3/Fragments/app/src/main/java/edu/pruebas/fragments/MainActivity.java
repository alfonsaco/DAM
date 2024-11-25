package edu.pruebas.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerLibros;
    private Button botonAgregarLibro;
    private ArrayList<Libro> listaLibros;
    private AdapterLibros adaptadorLibros;

    // Launcher para el resultado de la actividad de agregar libro
    private final ActivityResultLauncher<Intent> agregarLibroLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Libro nuevoLibro = result.getData().getParcelableExtra("nuevoLibro");
                    if (nuevoLibro != null) {
                        listaLibros.add(nuevoLibro);
                        adaptadorLibros.notifyItemInserted(listaLibros.size() - 1);
                        Toast.makeText(this, "Libro añadido: " + nuevoLibro.getTitulo(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No se agregó ningún libro", Toast.LENGTH_SHORT).show();
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de libros
        listaLibros=new ArrayList<>();

        recyclerLibros = findViewById(R.id.recycler);
        botonAgregarLibro = findViewById(R.id.btnAgregarLibro);

        configurarRecyclerView();

        // Se añaden libros por defecto
        agregarLibroPredeterminado();

        botonAgregarLibro.setOnClickListener(view -> abrirActividadNuevoLibro());
    }

    // Método para agregar un libro predeterminado
    private void agregarLibroPredeterminado() {
        Libro quijote = new Libro("El Quijote", "Miguel de Cervantes", 1605, "La historia de un hidalgo que se convierte en caballero andante.");
        listaLibros.add(quijote);
        Libro milNovecientosOchentaYCuatro = new Libro("1984", "George Orwell", 1949, "Una novela distópica que explora temas de opresión y control totalitario.");
        listaLibros.add(milNovecientosOchentaYCuatro);
        Libro cienAnosSoledad = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Una obra maestra del realismo mágico que narra la historia de la familia Buendía.");
        listaLibros.add(cienAnosSoledad);
    }

    // Configura el RecyclerView
    private void configurarRecyclerView() {
        adaptadorLibros = new AdapterLibros(listaLibros, this::mostrarFragmentoDetalle);
        recyclerLibros.setLayoutManager(new LinearLayoutManager(this));
        recyclerLibros.setAdapter(adaptadorLibros);
    }

    // Lanza la actividad para agregar un nuevo libro
    private void abrirActividadNuevoLibro() {
        Intent intent = new Intent(this, NuevoLibro.class);
        agregarLibroLauncher.launch(intent);
    }

    // Muestra el fragmento con los detalles del libro
    private void mostrarFragmentoDetalle(Libro libro) {
        Log.d("MainActivity", "Mostrando fragmento para el libro: " + libro.getTitulo());
        BlankFragment fragment = BlankFragment.newInstance(libro);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();

        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
        recyclerLibros.setVisibility(View.GONE);
    }

}
