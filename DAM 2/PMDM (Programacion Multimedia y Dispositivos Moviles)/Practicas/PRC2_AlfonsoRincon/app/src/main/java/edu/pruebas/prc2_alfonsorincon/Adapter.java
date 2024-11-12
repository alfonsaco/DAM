package edu.pruebas.prc2_alfonsorincon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
/*
    CLASE PARA CREAR EL SPINNER, CON TODOS SUS ITEMS
 */
public class Adapter extends ArrayAdapter<Items> {

    public Adapter(@NonNull Context context, ArrayList<Items> listaItems) {
        super(context, 0, listaItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return vistaCreada(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return vistaCreada(position, convertView, parent);
    }

    public View vistaCreada(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, parent, false);
        }

        Items items=getItem(position);
        ImageView imagen=convertView.findViewById(R.id.ivCustomSpinner);
        TextView texto=convertView.findViewById(R.id.tvCustomSpinner);
        if(items != null) {
            imagen.setImageResource(items.getImagen());
            texto.setText(items.getTexto());
        }

        return convertView;
    }
}
