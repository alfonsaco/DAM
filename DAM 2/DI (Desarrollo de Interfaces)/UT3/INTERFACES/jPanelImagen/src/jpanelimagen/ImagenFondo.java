/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author PROGRAMACION
 */
public class ImagenFondo implements Serializable {
    private File ruta;
    private Float opacidad;

    public ImagenFondo(File ruta, Float opacidad) {
        this.ruta = ruta;
        this.opacidad = opacidad;
    }
    
    // Getters y Setters
    public File getRuta() {
        return ruta;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }

    public Float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(Float opacidad) {
        this.opacidad = opacidad;
    }
}
