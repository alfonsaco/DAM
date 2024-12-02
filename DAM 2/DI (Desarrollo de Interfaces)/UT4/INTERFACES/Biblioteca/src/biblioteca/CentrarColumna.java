/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Alfonso
 */
public class CentrarColumna extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        // Llama al método padre para obtener el componente de celda
        Component cell = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        // Centra el texto en todas las columnas
        setHorizontalAlignment(SwingConstants.CENTER);
        
        return cell;
    }
    
    
    
}
