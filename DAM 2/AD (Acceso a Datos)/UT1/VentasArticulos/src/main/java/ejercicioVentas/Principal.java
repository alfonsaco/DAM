package ejercicioVentas;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Principal {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context;
		try {
		    context = JAXBContext.newInstance(ventasArticulos.class);
			Unmarshaller unmars = context.createUnmarshaller();
			ventasArticulos objeto = (ventasArticulos) unmars.unmarshal(new File(".\\ventasarticulos.xml"));

		    Articulo articulo=objeto.getArticulo();
		    ArrayList<Venta> listaVentas=objeto.getVentas();
			
			System.out.println("Código: "+articulo.getCodigo()+"   Nombre: "+articulo.getDenominacion()+"   PVP: "+articulo.getPrecio());
			System.out.printf("%9s %11s %-25s %10s %8s\n","NUM VENTA","FECHA VENTA","NOM-CLIENTE","UNIDADES","IMPORTE");
			System.out.printf("%9s %11s %25s %10s %8s\n","---------","-----------","-------------------------","----------","--------");
			
			float importe=0;
			float sumImporte=0;
			int totalUnidades=0;
			
			for (Venta venta : listaVentas) {
				importe=venta.getUnidades()*articulo.getPrecio();
				sumImporte+=importe;
				totalUnidades+=venta.getUnidades();
				System.out.printf("%9s %11s %25s %10s %8s\n",venta.getNumVenta(),venta.getFecha(),venta.getNombreCliente(),venta.getUnidades(), importe);
			}
			
			System.out.printf("%9s %11s %25s %10s %8s\n","---------","-----------","-------------------------","----------","--------");
			System.out.printf("%9s %11s %25s %10s %8s\n"," "," "," ",totalUnidades,sumImporte);

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
