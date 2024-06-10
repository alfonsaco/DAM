package Aparcamiento;

public interface Valida {
	// Verificar DNI o Matricula
	public static boolean valida(String cadena) {
		String[] letras= {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

		if(cadena.matches("[0-9]{8}[a-zA-Z]{1}") || cadena.matches("[0-9]{4}[a-zA-Z]{3}")) {
			if(cadena.matches("[0-9]{8}[a-zA-Z]{1}")) {
				if(letras[Integer.parseInt(cadena.substring(0,cadena.length()-1))%23].equals(cadena.substring(cadena.length()-1, cadena.length()))) {
					return true;
				}
			} else if(cadena.matches("[0-9]{4}[a-zA-Z]{3}")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		return false;
	}
}
