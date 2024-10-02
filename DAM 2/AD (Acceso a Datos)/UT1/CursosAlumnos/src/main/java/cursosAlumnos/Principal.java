package cursosAlumnos;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Principal {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context;
		
		try {
		    context = JAXBContext.newInstance(cursosAlumnos.class);
			Unmarshaller unmars = context.createUnmarshaller();
			cursosAlumnos objeto = (cursosAlumnos) unmars.unmarshal(new File(".\\cursosalumnosVer2.xml"));

			ArrayList<Curso> cursos=objeto.getCursos();
			System.out.println("Número de cursos: "+cursos.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
