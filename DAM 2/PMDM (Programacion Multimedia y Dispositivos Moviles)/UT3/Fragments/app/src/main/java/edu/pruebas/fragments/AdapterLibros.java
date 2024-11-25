package edu.pruebas.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterLibros extends RecyclerView.Adapter<AdapterLibros.LibroViewHolder> {

    private final List<Libro> libros;
    private final OnLibroClickListener listener;

    public interface OnLibroClickListener {
        void onLibroClick(Libro libro);
    }

    public AdapterLibros(List<Libro> libros, OnLibroClickListener listener) {
        this.libros = libros;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.libro, parent, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        Libro libro = libros.get(position);
        holder.bind(libro, listener);
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    static class LibroViewHolder extends RecyclerView.ViewHolder {
        private final TextView titulo;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.nombreLibro);
        }

        public void bind(Libro libro, OnLibroClickListener listener) {
            titulo.setText(libro.getTitulo());
            itemView.setOnClickListener(v -> listener.onLibroClick(libro));
        }
    }
}

