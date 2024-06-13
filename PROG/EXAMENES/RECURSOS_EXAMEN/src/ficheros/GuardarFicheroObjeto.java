

	private void guardarCliente() {
		try {
			FileOutputStream fo=new FileOutputStream("clientes.par");
			ObjectOutputStream salida=new ObjectOutputStream(fo);
			for(Cliente c : this.getClientesaparcamiento()) {
				salida.writeObject(c);
			}
			salida.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}