package com.examen.ut3;


public class PruebaCliente {
    public static void main(String[] args) {
        // Creación de un objeto ClienteElectricidad
        ClienteElectricidad cliente1 = new ClienteElectricidad("12345", true, 150, 6);
        cliente1.calcularTotalFactura();
        System.out.println("El total de la factura para el cliente 1 es: " + cliente1.getTotalFactura());

        // Creación de otro objeto ClienteElectricidad
        ClienteElectricidad cliente2 = new ClienteElectricidad("67890", false, 300, 11);
        cliente2.calcularTotalFactura();
        System.out.println("El total de la factura para el cliente 2 es: " + cliente2.getTotalFactura());
    }
}


