

// CARGAR FICHERO EN UN OBJETO:
// En el fichero visitasHoy.txt están los valores de los objetos visita de cada turista. En el método 
// cargarVisita asígnale al turista que invoque el método(this) su objeto visita correspondiente
/*
 * Se carga en un objeto en lugar de en un ArrayList
 */
public void cargarVisita(String filename) {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File(filename));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		// PARTE IMPORTANTE
        		if(linea[1].equals(this.getId())) {
            		Visita v=new Visita(linea[2],Integer.parseInt(linea[3]),linea[4],Double.parseDouble(linea[5]));
            		this.setVisita(v);
        		}
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}


// CARGAR FICHERO EN UN ARRAYLIST:
public void clasesMonitor(String mes) {
	try {
    	String cadena;
        String[] linea;
    	Scanner entrada=new Scanner(new File("asistencia"+mes+"2023.csv"));
    	entrada.nextLine(); // Se salta la primera línea
    	while(entrada.hasNext()) {
    		cadena=entrada.nextLine();
    		linea=cadena.split(";");
    		if(this.getCodigoMonitor() == Integer.parseInt(linea[5])) {
        		this.getClases().add(new Clase(Integer.parseInt(linea[0]),linea[1],Integer.parseInt(linea[2]),linea[3],linea[4],Integer.parseInt(linea[5]),Integer.parseInt(linea[6])));
    		}
    	}
	} catch (FileNotFoundException e) {
		System.err.println("Fichero no encontrado");
		e.printStackTrace();
	}
}