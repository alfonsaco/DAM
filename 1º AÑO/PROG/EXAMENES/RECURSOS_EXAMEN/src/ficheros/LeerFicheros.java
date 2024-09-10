	




	private void leerConductores() {
		try {
        	String cadena;
            String[] linea;
        	Scanner entrada=new Scanner(new File("conductor.csv"));
        	entrada.nextLine(); // Se salta la primera línea
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		this.getConductores().add(new Conductor(linea[0],linea[1],linea[2],linea[3],linea[4],linea[5]));
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}