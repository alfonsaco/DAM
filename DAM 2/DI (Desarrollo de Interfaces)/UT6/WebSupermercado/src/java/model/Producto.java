/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alfonso
 */
public class Producto {
    private String nombre;
    private String direccion;
    private int cantidad;
    private Float precio;

    // Constructores
    public Producto() {
    }
    public Producto(String nombre, String direccion, int cantidad, Float precio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }     
}
