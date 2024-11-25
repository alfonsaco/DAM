package edu.pruebas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

    private Libro libro;
    TextView texto;

    public static BlankFragment newInstance(Libro libro) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putParcelable("libro", libro);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            libro = getArguments().getParcelable("libro");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        texto=view.findViewById(R.id.texto);

        // Añadir el libr con sus datos
        if (libro != null) {
            String textoConFormato = "Título: " + libro.getTitulo() + "\n"
                    + "Autor: " + libro.getAutor() + "\n"
                    + "Año: " + libro.getAñoPublicacion() + "\n"
                    + "Descripción: " + libro.getDescripcion();
            texto.setText(textoConFormato);
        }

        return view;
    }
}
