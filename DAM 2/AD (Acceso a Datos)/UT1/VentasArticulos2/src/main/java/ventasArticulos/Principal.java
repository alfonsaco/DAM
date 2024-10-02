package ventasArticulos;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Principal {
	public static void main(String[] args) {
		JAXBContext context;
		
		try {
		    context = JAXBContext.newInstance(ventasArticulos.class);
			Unmarshaller unmars = context.createUnmarshaller();
			ventasArticulos objeto = (ventasArticulos) unmars.unmarshal(new File(".\\ventasarticulosdos.xml"));
			
			ArrayList<Articulo> articulos=objeto.getArticulos();
			
			System.out.println("Número de articulos: "+articulos.size());
			for (Articulo articulo : articulos) {
				System.out.println("Código: "+articulo.getArtic().getCodigo()+"    Nombre: "+articulo.getArtic().getDenominacion()+"    PVP: "+articulo.getArtic().getPrecio());
				System.out.printf("%10s %12s %25s %10s %10s\n","NUM VENTA","FECHA VENTA","NOM CLIENTE","UNIDADES","IMPORTE");
				System.out.printf("%10s %12s %25s %10s %10s\n","----------","------------","-------------------------","----------","----------");
				
				ArrayList<Venta> ventas=articulo.getVentas();
				int totalUnidades=0;
				double totalImporte=0;
				
				for (Venta v : ventas) {
					double importe=v.getUnidades()*articulo.getArtic().getPrecio();
					totalUnidades+=v.getUnidades();
					totalImporte+=importe;
					
					System.out.printf("%10s %12s %-25s %10s %10s\n",v.getNumventa(),v.getFecha(),v.getNombrecliente(),v.getUnidades(),importe);
				}
				System.out.printf("%10s %12s %25s %10s %10s\n","----------","------------","-------------------------","----------","----------");
				System.out.printf("%10s %12s %25s %10s %10s\n","TOTALES: ","","",totalUnidades,totalImporte);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}	
}
