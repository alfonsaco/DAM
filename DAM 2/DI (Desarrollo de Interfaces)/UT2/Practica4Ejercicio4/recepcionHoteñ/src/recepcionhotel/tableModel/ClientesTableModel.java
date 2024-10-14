/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recepcionhotel.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import recepcionhotel.beans.Cliente;

/**
 *
 * @author PROGRAMACION
 */
public class ClientesTableModel extends AbstractTableModel {
    private List<Cliente> listaClientes;

    public ClientesTableModel(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ClientesTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Cliente c=listaClientes.get(i);
        switch(i1) {
            case 0:
                return listaClientes.get(i1).getNombre();
            case 1:
                return listaClientes.get(i1).getApellidos();
            case 2:
                return listaClientes.get(i1).getCheckIn();
            case 3:
                return listaClientes.get(i1).getCheckOut();
            case 4:
                return listaClientes.get(i1).getNumHab();
            case 5:
                return listaClientes.get(i1).getTipoHab();
        }
        return null;
    }
    
}
