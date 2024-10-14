/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recepcionhotel.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import recepcionhotel.beans.Cliente;

/**
 *
 * @author Alfonso
 */
public class LogicaHotel {
    public List<Cliente> listaClientes=new ArrayList<Cliente>();

    public LogicaHotel() throws ParseException {
        listaClientes=new ArrayList<>();
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        
        listaClientes.add(new Cliente("Pedro","Pérez",sdf.parse("05-02-2024"),sdf.parse("07-09-2024"),10,"Suite"));
        listaClientes.add(new Cliente("María","García",sdf.parse("10-03-2024"),sdf.parse("15-03-2024"),5,"Doble"));
        listaClientes.add(new Cliente("Juan","Rodríguez",sdf.parse("22-04-2024"),sdf.parse("30-04-2024"),8,"Individual"));
        listaClientes.add(new Cliente("Laura","López",sdf.parse("12-05-2024"),sdf.parse("17-05-2024"),5,"Suite"));
        listaClientes.add(new Cliente("Carlos","Sánchez",sdf.parse("01-06-2024"),sdf.parse("05-06-2024"),4,"Doble"));
        listaClientes.add(new Cliente("Lucía","Martínez",sdf.parse("15-07-2024"),sdf.parse("22-07-2024"),7,"Individual"));
        listaClientes.add(new Cliente("Andrés","Hernández",sdf.parse("23-08-2024"),sdf.parse("30-08-2024"),7,"Suite"));
        listaClientes.add(new Cliente("Ana","Díaz",sdf.parse("02-09-2024"),sdf.parse("06-09-2024"),4,"Doble"));
        listaClientes.add(new Cliente("Miguel","Fernández",sdf.parse("10-10-2024"),sdf.parse("15-10-2024"),5,"Individual"));
        listaClientes.add(new Cliente("Pedro","Pérez",sdf.parse("05-02-2024"),sdf.parse("07-09-2024"),10,"Suite"));
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
}
