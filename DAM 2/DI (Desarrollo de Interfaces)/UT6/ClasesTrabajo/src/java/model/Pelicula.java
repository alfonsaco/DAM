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
public class Pelicula implements Serializable{

    private int id;
    private String nombre;
    private String genero;
    private boolean estadoVisualizacion;
    private int cineId;

    public Pelicula() {
        this.id = 0;
        this.nombre = "";
        this.genero = "";
        this.estadoVisualizacion = false;
        this.cineId = 0;
    }

    public Pelicula(int id, String nombre, String genero, boolean estadoVisualizacion, int cineId) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.estadoVisualizacion = estadoVisualizacion;
        this.cineId = cineId;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEstadoVisualizacion() {
        return estadoVisualizacion;
    }

    public void setEstadoVisualizacion(boolean estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    public int getCineId() {
        return cineId;
    }

    public void setCineId(int cineId) {
        this.cineId = cineId;
    }
    
}
