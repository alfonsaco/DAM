/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebafechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PROGRAMACION
 */
public class PruebaFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
        // Fecha a String con formato
        Date d=new Date();
        
        System.out.print(sdf.format(d));
       
        // String a fecha
        String fecha="10-02-2020";
        try {
            d=sdf.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    
}
