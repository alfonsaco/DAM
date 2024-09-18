package Ejercicios;

public class Nivel_5 {

	public static void main(String[] args) {
		int[] vector= {4,6,3,5,4,23,45,6,3,2,};
		int contImpares=0;
		int sumaImpares=0;
		// For para ver cuales son impares
		for (int i=0; i<vector.length; i++) {
			if(vector[i]%2 != 0) {
				contImpares++;
				sumaImpares+=vector[i];
			}
		}
		
		System.out.println("Media arimética: "+(sumaImpares/contImpares));
	}

}
