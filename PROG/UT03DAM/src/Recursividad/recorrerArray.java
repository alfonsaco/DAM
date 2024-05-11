package Recursividad;

public class recorrerArray {
	
    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int i=0;
        recorrerArrayRecursivo(array, i);
    }

    public static void recorrerArrayRecursivo(int[] array, int i) {
        if (i<array.length) {
            System.out.println("Elemento en la posición "+i+": "+array[i]);
            recorrerArrayRecursivo(array,i+1); 
        }
    }
}
