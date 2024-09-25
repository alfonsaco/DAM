

/*
 *   PARA USARLO SE DEBE IMPORTAR LA LIBRERIA DE JSON 
 * 
 */

	// Método para parsear los artistas
	private void parsearArtistas(JSONObject a) {
	    String nombre = (String)a.get("nombre");
	    long edad = (long)a.get("edad");
	    String pais = (String)a.get("pais");
	    long oyentes = (long)a.get("oyentes");
	    String canciones = (String)a.get("canciones");
	    this.getArtistas().add(new Artista(nombre, edad, pais, oyentes, canciones));
	}
	
	// Método para cargar los artistas
	private void cargarArtistas() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("artistas.json"));
			// Convertir obj en JSONObject
				JSONArray actJson =(JSONArray) obj;
			actJson.forEach(a -> parsearArtistas((JSONObject)a));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}