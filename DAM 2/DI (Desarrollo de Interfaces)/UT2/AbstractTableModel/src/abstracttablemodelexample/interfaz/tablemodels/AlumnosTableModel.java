/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstracttablemodelexample.interfaz.tablemodels;

import abstracttablemodelexample.beans.Alumno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alfonso
 */
public class AlumnosTableModel extends AbstractTableModel {
    private List<Alumno> listaAlumno;
    private String[] columnas={"Nombre","Curso"};

    public AlumnosTableModel(List<Alumno> listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
    
    
    @Override
    public int getRowCount() {
        return listaAlumno.size();
    }

    @Override
    public int getColumnCount() {
        // Número de atributos del Alumno.En este caso 2 (nombre, curso)
        return columnas.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        // i: fila   i1: columna
        switch(i1) {
            case 0:
                return listaAlumno.get(i).getNombre();
            case 1:
                return listaAlumno.get(i).getCurso();
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }
   
}
