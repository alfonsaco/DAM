/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author josec
 */
public class Cine implements Serializable{

    private int id;
    private String nombre;
    private String direcion;

    public Cine() {
        this.id = 0;
        this.nombre = "";
        this.direcion = "";
    }

    public Cine(int id, String nombre, String direcion) {
        this.id = id;
        this.nombre = nombre;
        this.direcion = direcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }
    
}
