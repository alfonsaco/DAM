/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alfonso
 */
public class JPanelImagen extends JPanel {

    private ImagenFondo imagen;

    public JPanelImagen() {
    }

    public ImagenFondo getImagen() {
        return imagen;
    }

    public void setImagen(ImagenFondo imagen) {
        this.imagen = imagen;
    }

    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(imagen != null) {
            if(imagen.getRuta() != null && imagen.getRuta().exists()) {
                ImageIcon imagenIcon=new ImageIcon(imagen.getRuta().getAbsolutePath());
                Graphics2D g2d=(Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imagen.getOpacidad()));
                g2d.drawImage(imagenIcon.getImage(), 0, 0, null);   
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
        }
    }

    
    
    
}
