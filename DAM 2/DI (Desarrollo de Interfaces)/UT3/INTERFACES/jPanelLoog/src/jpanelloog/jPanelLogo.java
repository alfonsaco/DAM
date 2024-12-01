/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelloog;

import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author PROGRAMACION
 */
public class jPanelLogo extends JPanel implements Serializable {
    private File rutaImagen;

    public jPanelLogo() {
    }

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File ritaImagen) {
        this.rutaImagen = ritaImagen;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(rutaImagen.exists() && rutaImagen != null) {
            ImageIcon imagen=new ImageIcon(rutaImagen.getAbsolutePath());
            g.drawImage(imagen.getImage(), 0, 0, null);
        }
    }
    
    
}
