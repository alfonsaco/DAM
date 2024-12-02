/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4interfaz;

import actividad4interfaz.pantallas.PantallaPrincipal;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Alfonso
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Aplicamos un Look and Feel
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
        // Abrimos el juego
        PantallaPrincipal p=new PantallaPrincipal();
        p.setVisible(true);                
    }
    
}
