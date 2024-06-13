

	// Método para parsear los artistas
	private void parsearCliente(JSONObject c) {
		String nombre = (String)c.get("nombre");
		long edad = (long)c.get("edad");
		String ciudad = (String)c.get("ciudad");
		
		JSONArray comprasJson = (JSONArray) c.get("compras");
		ArrayList<Producto> listaCompras = new ArrayList<>();
	    for (Object compraObj : comprasJson) {
	        JSONObject compraJson = (JSONObject) compraObj;
	        String nombreP = (String) compraJson.get("nombreP");
	        double precio = (double) compraJson.get("precio");
	        long cantidad = (long) compraJson.get("cantidad");
	        listaCompras.add(new Producto(nombreP, precio, cantidad));
	    }
	    this.getClientes().add(new Cliente(nombre, edad, ciudad, listaCompras));
	}

		
	// Método para cargar los artistas
	private void cargarCliente() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("clientes.json"));
			// Convertir obj en JSONObject
			JSONArray actJson =(JSONArray) obj;
			actJson.forEach(c -> parsearCliente((JSONObject)c));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}