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
				System.out.println("Código: "+articulo.getArtic().getDenominacion());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}	
}
