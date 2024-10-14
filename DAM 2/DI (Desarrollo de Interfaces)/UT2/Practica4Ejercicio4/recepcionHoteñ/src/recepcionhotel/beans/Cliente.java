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
    private Date checkIn;
    private Date checkOut;
    private int numHab;
    private String tipoHab;

    public Cliente(String nombre, String apellidos, Date checkIn, Date checkOut, int numHab, String tipoHab) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numHab = numHab;
        this.tipoHab = tipoHab;
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

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
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
}
