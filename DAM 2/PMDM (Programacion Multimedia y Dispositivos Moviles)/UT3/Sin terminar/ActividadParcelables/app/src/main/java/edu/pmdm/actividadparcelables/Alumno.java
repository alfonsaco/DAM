package edu.pmdm.actividadparcelables;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Alumno implements Parcelable {
    private String nombre;
    private int edad;
    private double mediaNotas;
    private ArrayList<Asignatura> asignaturas;

    // Constructor normal
    public Alumno(double mediaNotas, int edad, String nombre, ArrayList<Asignatura> asignaturas) {
        this.mediaNotas = mediaNotas;
        this.edad = edad;
        this.nombre = nombre;
        this.asignaturas = new ArrayList<>();
    }

    // Constructor del parcelable
    protected Alumno(Parcel in) {
        mediaNotas = in.readDouble();
        edad = in.readInt();
        nombre = in.readString();
        asignaturas = in.createTypedArrayList(Asignatura.CREATOR); // Leer lista de asignaturas
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
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Escribir los datos en el Parcel
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeDouble(mediaNotas);
        parcel.writeInt(edad);
        parcel.writeString(nombre);
        parcel.writeTypedList(asignaturas); // Escribir lista de asignaturas
    }

    // CREATOR
    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel parcel) {
            return new Alumno(parcel);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    // Convertir los datos a JSON (manual, sin bibliotecas externas)
    public String convertirJSON() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n");
        jsonBuilder.append("  \"nombre\": \"").append(nombre).append("\",\n");
        jsonBuilder.append("  \"edad\": ").append(edad).append(",\n");
        jsonBuilder.append("  \"mediaNotas\": ").append(mediaNotas).append(",\n");
        jsonBuilder.append("  \"asignaturas\": [\n");

        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura asignatura = asignaturas.get(i);
            jsonBuilder.append("    {\n");
            jsonBuilder.append("      \"nombreAsignatura\": \"").append(asignatura.getNombreAsignatura()).append("\",\n");
            jsonBuilder.append("      \"notaAsignatura\": ").append(asignatura.getNotaAsignatura()).append("\n");
            jsonBuilder.append("    }");
            if (i < asignaturas.size() - 1) {
                jsonBuilder.append(",\n");
            } else {
                jsonBuilder.append("\n");
            }
        }

        jsonBuilder.append("  ]\n");
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}