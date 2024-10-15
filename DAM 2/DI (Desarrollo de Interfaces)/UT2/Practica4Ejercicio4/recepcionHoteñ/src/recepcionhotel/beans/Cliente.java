/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recepcionhotel.beans;

import java.util.Date;

/**
 *
 * @author PROGRAMACION
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private String checkIn;
    private String checkOut;
    private int numHab;
    private String tipoHab;
    private String dni;

    public Cliente(String nombre, String apellidos, String checkIn, String checkOut, int numHab, String tipoHab, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numHab = numHab;
        this.tipoHab = tipoHab;
        this.dni = dni;
    }
    public Cliente() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
