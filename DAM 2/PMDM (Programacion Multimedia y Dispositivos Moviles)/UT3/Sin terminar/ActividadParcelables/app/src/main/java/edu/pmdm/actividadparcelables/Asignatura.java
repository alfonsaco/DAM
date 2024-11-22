package edu.pmdm.actividadparcelables;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Asignatura implements Parcelable {
    String nombreAsignatura;
    double notaAsignatura;

    public Asignatura(double notaAsignatura, String nombreAsignatura) {
        this.notaAsignatura = notaAsignatura;
        this.nombreAsignatura = nombreAsignatura;
    }

    protected Asignatura(Parcel in) {
        nombreAsignatura = in.readString();
        notaAsignatura = in.readDouble();
    }

    public static final Creator<Asignatura> CREATOR = new Creator<Asignatura>() {
        @Override
        public Asignatura createFromParcel(Parcel in) {
            return new Asignatura(in);
        }

        @Override
        public Asignatura[] newArray(int size) {
            return new Asignatura[size];
        }
    };

    // Getters y Setters
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    public void setNotaAsignatura(double notaAsignatura) {
        this.notaAsignatura = notaAsignatura;
    }
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
    public double getNotaAsignatura() {
        return notaAsignatura;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombreAsignatura);
        parcel.writeDouble(notaAsignatura);
    }
}
