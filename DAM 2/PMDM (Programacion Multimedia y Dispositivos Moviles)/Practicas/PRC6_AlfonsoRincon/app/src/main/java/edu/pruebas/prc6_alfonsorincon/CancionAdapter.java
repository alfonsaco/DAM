package edu.pruebas.prc6_alfonsorincon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CancionAdapter extends RecyclerView.Adapter<CancionAdapter.ViewHolder> {
    private List<Cancion> listaCanciones;
    private Context context;

    public CancionAdapter(Context context, List<Cancion> canciones) {
        this.context = context;
        this.listaCanciones = canciones;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cancion, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CancionAdapter.ViewHolder holder, int position) {
        Cancion cancion=listaCanciones.get(position);

        // Mostrar los datos
        // Textos
        holder.txtAutor.setText(cancion.getAutor());
        holder.txtNombreCancion.setText(cancion.getNombre());

        // Imágenes
        // Como el método para obtener la imagen utiliza "R.drawable.imagen" en lugar de "R.drawable.imagen.jpg", uso
        // esta cadena, que contendrá el nombre de la imagen
        String nombreImagen=cancion.getImagen().toLowerCase().replace(".png","").replace(".jpg","");
        int portadaId=context.getResources().getIdentifier(
                nombreImagen,
                "drawable",
                context.getPackageName()
        );
        Glide.with(context).load(portadaId != 0 ? portadaId : R.drawable.placeholder).into(holder.portadaAlbum);

        // Obtener el tipo de imagen
        if(Integer.parseInt(cancion.getTipo()) == 0) {
            int tipoID=context.getResources().getIdentifier("audio", "drawable", context.getPackageName());
            Glide.with(context).load(tipoID).into(holder.imagenTipoCancion);

        } else if(Integer.parseInt(cancion.getTipo()) == 1) {
            int tipoID=context.getResources().getIdentifier("video", "drawable", context.getPackageName());
            Glide.with(context).load(tipoID).into(holder.imagenTipoCancion);

        } else if(Integer.parseInt(cancion.getTipo()) == 2) {
            int tipoID=context.getResources().getIdentifier("streaming", "drawable", context.getPackageName());
            Glide.with(context).load(tipoID).into(holder.imagenTipoCancion);

        }
    }

    @Override
    public int getItemCount() {
        return listaCanciones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton btnReproducirCancion;
        ImageView portadaAlbum;
        ImageView imagenTipoCancion;
        TextView txtAutor;
        TextView txtNombreCancion;

        public ViewHolder(View itemView) {
            super(itemView);

            btnReproducirCancion=itemView.findViewById(R.id.btnReproducirCancion);
            portadaAlbum=itemView.findViewById(R.id.portadaAlbum);
            imagenTipoCancion=itemView.findViewById(R.id.imagenTipoCancion);
            txtAutor=itemView.findViewById(R.id.txtAutor);
            txtNombreCancion=itemView.findViewById(R.id.txtNombreCancion);
        }
    }
}
