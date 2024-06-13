

	private void leerClientes() {
		try {
			System.out.println("Se inicializará de nuevo el array de clientes perdiendo los datos anteriores que no haya guardado");
			this.setClientesaparcamiento(new ArrayList<Cliente>());
			FileInputStream fi=new FileInputStream("clientes.par");
			ObjectInputStream entrada=new ObjectInputStream(fi);
			
			Cliente c=null;
			while(entrada!=null) {
				try {
					c=(Cliente)entrada.readObject();
					this.getClientesaparcamiento().add(c);
				} catch (Exception e){
					entrada=null;
				}
			}
			for (Cliente cli : this.getClientesaparcamiento()) {
				System.out.println(cli.getNombre());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}