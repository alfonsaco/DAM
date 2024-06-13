package Examen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.File;
import java.util.ArrayList;

public class App implements Informe, Serializable {

	@Override
	public void informeVentas() {
		File carpeta=new File("Ventas");
		if(!carpeta.exists()) {
			carpeta.mkdir();
		}
		
		PrintWriter salida;
		BD bd=BD.getInstance();
		try {
			salida = new PrintWriter(new File(carpeta,"Ventas2022.txt"));
			salida.println("############### VENTAS ###############");
			ArrayList<Cliente> clientes=bd.cargarClientes();
			double total=0;
			for (Cliente c : clientes) {
				c.cargarHistorico();
				salida.println("********** CLIENTE **********");
				for (Pedido p : c.getHistoricoPedidos()) {
					if(p.getDniCliente().equals(c.getDni())) {
						total+=p.getTotal();	
					}
				}
				salida.println(c.getNombre()+" "+c.getApellidos()+"  "+total+"€");
				salida.println("------------------------------");
			}
			salida.flush();
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BD bd=BD.getInstance();
		App app=new App();
	
		ArrayList<Cliente> clientes=bd.cargarClientes();
		
		for (Cliente c : clientes) {
			c.asignarMetodoPago();
		}

		if(args.length==1) {
			// Prueba unitaria: --cliente=44444444J
			for (Cliente c : clientes) {
				if(c.getDni().equals(args[0].split("=")[1])) {
					c.cargarHistorico();
					System.out.println("Cliente: "+c.getNombre()+" "+c.getApellidos());
					System.out.println("Método de pago: "+c.getMetodoPago());
					System.out.println("Pedidos realizadso en 2022:");
					double suma=0;
					for (Pedido p : c.getHistoricoPedidos()) {
						if(p.getDniCliente().equals(c.getDni())) {
							System.out.println("\t"+p.getCodigoPedido()+" -> "+p.getTotal()+"€");
							suma+=p.getTotal();	
						}
					}
					System.out.println();
					System.out.println("IMPORTE TOTAL: "+suma+"€");
				}
			}
		} else if (args.length==0) {
			app.informeVentas();
		}
	}

}
