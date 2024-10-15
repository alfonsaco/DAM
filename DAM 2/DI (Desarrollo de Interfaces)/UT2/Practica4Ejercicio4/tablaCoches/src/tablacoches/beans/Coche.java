/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablacoches.beans;

/**
 *
 * @author PROGRAMACION
 */
public class Coche {
    private String marca;
    private String modelo;
    private int numPuertas;
    private String color;

    public Coche(String marca, String modelo, int numPuertas, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
        this.color = color;
    }
    public Coche() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
