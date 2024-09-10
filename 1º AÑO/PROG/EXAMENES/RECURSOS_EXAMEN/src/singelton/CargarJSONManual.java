// Método para cargar el JSON de forma manual, sin usar las bibliotecas esas raras
package singelton;




public void cargarParametrosConexionJSON(String fichero) {
		
		try {
			Scanner entrada = new Scanner(new File(fichero));
			String cadena;
			String conexion = ""; 
			String usuario = "";
			String contraseña = "";
			
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				if(cadena.contains("DRIVER")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length())+":"+cadena.split(":")[2]+":"+cadena.split(":")[3]+":";
				}
				if(cadena.contains("SERVIDOR")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2)+":";
				}
				if(cadena.contains("PUERTO")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2)+":";
				}
				if(cadena.contains("SID")) {
					conexion+=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2);
				}
				if(cadena.contains("USUARIO")) {
					usuario=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-2);
				}
				if(cadena.contains("CLAVE")) {
					contraseña=cadena.split(":")[1].substring(2,cadena.split(":")[1].length()-1);
				}
			}

			this.cadenaConexion = conexion;
			this.usuario = usuario;
			this.pass = contraseña;
			System.out.println(conexion);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
