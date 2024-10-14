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
    private String[] columnas={"Nombre","Apellidos","Check In","Check Out","Número habitación","Tipo Habitación"};

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
                return c.getNombre();
            case 1:
                return c.getApellidos();
            case 2:
                return c.getCheckIn();
            case 3:
                return c.getCheckOut();
            case 4:
                return c.getNumHab();
            case 5:
                return c.getTipoHab();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }
    
    
    
}
