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
import java.util.Locale;
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
        Date d1=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy", new Locale("es","ES"));
        
        listaClientes.add(new Cliente("Pedro","Pérez","05-02-2024","07-09-2024",10,"Suite", "12345678A"));
        listaClientes.add(new Cliente("María","García","10-03-2024","15-03-2024",5,"Doble", "23456789B"));
        listaClientes.add(new Cliente("Juan","Rodríguez","22-04-2024","30-04-2024",8,"Individual", "34567890C"));
        listaClientes.add(new Cliente("Laura","López","12-05-2024","17-05-2024",5,"Suite", "45678901D"));
        listaClientes.add(new Cliente("Carlos","Sánchez","01-06-2024","05-06-2024",4,"Doble", "56789012E"));
        listaClientes.add(new Cliente("Lucía","Martínez","15-07-2024","22-07-2024",7,"Individual", "67890123F"));
        listaClientes.add(new Cliente("Andrés","Hernández","23-08-2024","30-08-2024",7,"Suite", "78901234G"));
        listaClientes.add(new Cliente("Ana","Díaz","02-09-2024","06-09-2024",4,"Doble", "89012345H"));
        listaClientes.add(new Cliente("Miguel","Fernández","10-10-2024","15-10-2024",5,"Individual", "90123456I"));
        listaClientes.add(new Cliente("Pedro","Pérez","05-02-2024","07-09-2024",10,"Suite", "12345678A"));

    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
