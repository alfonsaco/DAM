package actividadContraseña;

public class appPassword {
	public static void main(String[] args) {
		Password pass1=new Password();
		Password pass2=new Password();
		
		// Decir la longitud de cada cadena
		System.out.println();
		System.out.println("La longitud de "+pass1.getContrasena()+" es "+pass1.getLongitud());
		System.out.println("La longitud de "+pass2.getContrasena()+" es "+pass2.getLongitud());
		
		// Verficiar si son iguales
		System.out.println();
		if(pass1.getContrasena().equals(pass2.getContrasena())) {
			System.out.println(pass1.getContrasena()+" y "+pass2.getContrasena()+" son iguales");
		}else {
			System.out.println(pass1.getContrasena()+" y "+pass2.getContrasena()+" no son iguales");
		}
	}
}
