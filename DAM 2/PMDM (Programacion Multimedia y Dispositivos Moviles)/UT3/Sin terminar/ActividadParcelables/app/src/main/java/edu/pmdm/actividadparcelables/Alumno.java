package edu.pmdm.actividadparcelables;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Alumno implements Parcelable {
    String nombre;
    int edad;
    double mediaNotas;

    // Constructor normal
    public Alumno(double mediaNotas, int edad, String nombre) {
        this.mediaNotas = mediaNotas;
        this.edad = edad;
        this.nombre = nombre;
    }

    // Constructor del parcelable
    public Alumno(Parcel in) {
        mediaNotas=in.readDouble();
        edad=in.readInt();
        nombre=in.readString();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getMediaNotas() {
        return mediaNotas;
    }
    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    // Escribir los datos en el paarcel
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeDouble(mediaNotas);
        parcel.writeInt(edad);
        parcel.writeString(nombre);
    }

    // CREATOR: sirve para reconstruir objetos desde el Parcel
    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel parcel) {
            return new Alumno(parcel);
        }
        @Override
        public Alumno[] newArray(int i) {
            return new Alumno[i];
        }
    };
}
