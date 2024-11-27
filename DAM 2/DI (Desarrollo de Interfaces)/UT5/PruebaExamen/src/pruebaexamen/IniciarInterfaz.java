/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaexamen;

import java.util.Locale;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import pruebaexamen.pantallas.PantallaPrincipal;

/**
 *
 * @author Alfonso
 */
public class IniciarInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaSkin");
        
        Locale.setDefault(new Locale("it","IT"));
        
        PantallaPrincipal p=new PantallaPrincipal();
        p.setVisible(true);
    }
    
}
