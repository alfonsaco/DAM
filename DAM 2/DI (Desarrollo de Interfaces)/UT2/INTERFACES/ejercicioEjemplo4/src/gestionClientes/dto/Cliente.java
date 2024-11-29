/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionClientes.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PROGRAMACION
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private Date fechaAlta;
    private String provincia;
    private SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    // Constructor
    public Cliente(String nombre, String apeliidos, Date fechaAlta, String provincia) {
        this.nombre = nombre;
        this.apellidos = apeliidos;
        this.fechaAlta = fechaAlta;
        this.provincia=provincia;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public String getApeliidos() {
        return apellidos;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApeliidos(String apeliidos) {
        this.apellidos = apeliidos;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String[] toArrayString() {
        String[] s=new String[4];
        s[0]=nombre;
        s[1]=apellidos;
        s[2]=sdf.format(fechaAlta);
        s[3]=provincia;
        
        return s;           
    }
    
}
