package edu.pruebas.fragments;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Libro implements Parcelable {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String descripcion;

    // Constructor
    public Libro(String titulo, String autor, int añoPublicacion, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.descripcion = descripcion;
    }

    // Constructor Parcelable
    protected Libro(Parcel in) {
        titulo = in.readString();
        autor = in.readString();
        añoPublicacion = in.readInt();
        descripcion = in.readString();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(autor);
        parcel.writeInt(añoPublicacion);
        parcel.writeString(descripcion);
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
