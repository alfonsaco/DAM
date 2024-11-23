package edu.pruebas.sharemybike;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.pruebas.sharemybike.bikes.BikesContent;

// Adapter para conectar los datos (bikeList) con el RecyclerView
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    // Lista de bicicletas que se mostrarán
    private final List<BikesContent.Bike> bikeList;
    // Contexto de la aplicación para acceder a recursos o iniciar actividades
    private final Context context;

    // Constructor del adapter: recibe el contexto y la lista de bicicletas
    public MyItemRecyclerViewAdapter(Context context, List<BikesContent.Bike> items) {
        this.context = context; // Contexto actual (necesario para algunas operaciones, como iniciar un Intent)
        this.bikeList = items; // Lista de bicicletas a mostrar
    }

    // Método que infla (crea) las vistas individuales de cada fila
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño de una fila (layout_items_recycler.xml)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_items_recycler, parent, false);
        return new ViewHolder(view); // Retorna un ViewHolder que contiene los elementos de la fila
    }

    // Método que vincula los datos de una bicicleta específica con su vista correspondiente
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        // Obtiene el objeto de bicicleta en la posición actual
        BikesContent.Bike bike = bikeList.get(position);

        // Asigna los valores de la bicicleta a las vistas (nombre, descripción, imagen)
        holder.txtAutor.setText(bike.getOwner()); // Establece el nombre del propietario
        holder.txtDescripcion.setText(bike.getDescription()); // Establece la descripción de la bicicleta
        holder.imagenBici.setImageBitmap(bike.getPhoto()); // Establece la imagen de la bicicleta

        // Configura el botón "Email" para enviar un correo electrónico al propietario
        holder.btnEmailAutor.setOnClickListener(v -> {
            // Crea un Intent para enviar un correo
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain"); // Define el tipo de contenido como texto plano
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{bike.getEmail()}); // Dirección de correo del propietario
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bike Request"); // Asunto del correo
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear " + bike.getOwner() + ",\n\n" +
                    "I'd like to use your bike at " + bike.getLocation() + " (" + bike.getCity() + ").\n\n" +
                    "Can you confirm its availability?\n\nThank you!"); // Cuerpo del correo

            // Inicia la aplicación de correo electrónico para enviar el mensaje
            context.startActivity(Intent.createChooser(emailIntent, "Send Email"));
        });
    }

    // Devuelve la cantidad de elementos en la lista (número de bicicletas)
    @Override
    public int getItemCount() {
        return bikeList.size();
    }


    // Clase interna que representa cada fila del RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Referencias a las vistas individuales dentro de una fila
        public final ImageView imagenBici; // Imagen de la bicicleta
        public final TextView txtAutor; // Nombre del propietario
        public final TextView txtDescripcion; // Descripción de la bicicleta
        public final ImageButton btnEmailAutor; // Botón para enviar correo
        TextView txtDireccion;
        TextView txtCiudad;

        // Constructor del ViewHolder: enlaza las vistas de la fila con sus IDs en el diseño XML
        public ViewHolder(View view) {
            super(view);

            // Comenta estas líneas porque las vistas no están configuradas actualmente
            imagenBici = view.findViewById(R.id.imagenBici); // Busca la vista para la imagen
            txtAutor = view.findViewById(R.id.txtAutor); // Busca la vista para el nombre del propietario
            txtDescripcion = view.findViewById(R.id.txtDescripcion); // Busca la vista para la descripción
            btnEmailAutor = view.findViewById(R.id.btnEmailAutor); // Busca la vista para el botón de correo
            txtDireccion=view.findViewById(R.id.txtDireccion);
            txtCiudad=view.findViewById(R.id.txtCiudad);
        }
    }
}
