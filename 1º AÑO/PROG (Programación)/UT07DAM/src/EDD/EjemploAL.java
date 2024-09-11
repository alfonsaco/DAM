package EDD;

import java.util.ArrayList;

public class EjemploAL {
	public static void main(String[] args) {
		ArrayList <Integer> numeros=new ArrayList<>();
		
		numeros.add(3);
		numeros.add(5);
		numeros.add(10);
		numeros.add(0,1); //añado en la posición 0 el número 1
		
		System.out.println(numeros);
		numeros.add(1,2);
		System.out.println(numeros); //en la posición 1 (primer número), guardo el 2 (segundo número)
		
		//borrar un número de un AL
		numeros.remove(1);  //ponemos la posicion del número a borrar
		System.out.println(numeros);
		
		
		System.out.println();
		
		//recorrer un AL
		for(int i=0; i<numeros.size(); i++) {   //se pone .size() en lugar de .lenght
			System.out.println(numeros.get(i));
		}
		System.out.println();
		
		//usar for each para imprimir AL
		for(Integer i: numeros) {
			System.out.println(i);
		}
		
		
		System.out.println();
		
		//borramos el AL completo
		numeros.clear();
		System.out.println(numeros);
		
	}
}
