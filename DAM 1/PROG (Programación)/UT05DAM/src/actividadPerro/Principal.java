package actividadPerro;

public class Principal {
	public static void main(String[] args) {
		Perro perro1=new Perro("Tobby", "Chihuahua", 8);
		Perro perro2=new Perro("Luna", "Labrador", 5);
		
		// Para ver cual es mayor
		if(perro1.getEdad()>perro2.getEdad()) {
			System.out.println(perro1.getNombre()+" es mayor");
		}else {
			System.out.println(perro2.getNombre()+" es mayor");
		}
		
		// Para verificar si tiene sobrepeso o no
		perro1.setSobrepeso(true);
		perro2.setSobrepeso(false);
		System.out.println(perro1.getNombre()+" tiene sobrepeso? "+(perro1.isSobrepeso() ? "Si" : "No"));
		System.out.println(perro2.getNombre()+" tiene sobrepeso? "+(perro2.isSobrepeso() ? "Si" : "No"));
		
		// Para decir la longitud del nombre
		System.out.println("La longitud del nombre de "+perro1.getNombre()+" es "+perro1.getNombre().length());
		System.out.println("La longitud del nombre de "+perro2.getNombre()+" es "+perro2.getNombre().length());
	}
}
