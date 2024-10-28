/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PROGRAMACION
 */
public class JPanelImagen extends JPanel implements Serializable {

    private File rutaImagen;
    
    // Constructor
    public JPanelImagen() {
    }

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(rutaImagen != null && rutaImagen.exists()) {
            ImageIcon imagen=new ImageIcon(rutaImagen.getAbsolutePath());
            g.drawImage(imagen.getImage(), 0, 0, null);   
        }
    }

    
    
    
}
