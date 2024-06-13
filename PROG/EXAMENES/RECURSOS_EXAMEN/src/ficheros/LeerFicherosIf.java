
	

	public void cargaActividades() {
		String cadena;
        String[] linea;
        try {
        	Scanner entrada=new Scanner(new File("reservaPendientes.csv"));
        	entrada.nextLine();
        	while(entrada.hasNext()) {
        		cadena=entrada.nextLine();
        		linea=cadena.split(";");
        		if (linea[2].equals(this.getCodigo())) {
        			this.getListaActividades().add(new ActividadReservada(linea[0], linea[1], linea[2], linea[3], linea[4]));
        		}
        	}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		}
	}