/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablacoches.logica;

import java.util.ArrayList;
import java.util.List;
import tablacoches.beans.Coche;

/**
 *
 * @author PROGRAMACION
 */
public class LogicaNegocio {
    private static List<Coche> listaCoches=new ArrayList<>();
    
    public void anadirCoche(Coche c) {
        listaCoches.add(c);
    }

    public static List<Coche> getListaCoches() {
        return listaCoches;
    }
    
    
}
