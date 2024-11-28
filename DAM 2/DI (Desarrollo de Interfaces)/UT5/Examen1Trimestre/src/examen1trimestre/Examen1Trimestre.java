/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1trimestre;

import examen1trimestre.pantallas.PantallaPrincipal;
import java.util.Locale;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Alfonso
 */
public class Examen1Trimestre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Look and Feel
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaSkin");
        
        // Idioma
        Locale.setDefault(new Locale("es","ES"));
        
        // Abrir la PantallaPrincipal
        PantallaPrincipal p=new PantallaPrincipal();
        p.setVisible(true);
    }
    
}
