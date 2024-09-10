

	public void generarBoletines(){
		for(Alumno a: this.getDam()) {
			PrintWriter salida;
			double suma=0;
			try {
				salida = new PrintWriter(new File("boletines/Boletin "+a.getNombre()+" "+a.getApellidos()+".txt"));
				salida.println("IES RIBERA DEL TAJO*");
				salida.println(a.getNombre()+" "+a.getApellidos()+"\n");
				for(Nota n: a.getNotas()) {
					salida.println("\t"+n);
					suma+=n.getNota();
				}
				salida.println("La nota media es: "+(suma/a.getNotas().size()));
				salida.flush();
				salida.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}