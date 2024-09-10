package Recursos_Basicos_PT2;

public class recorrerArrayInverso {
    
	public static void main(String[] args) {
        int[]array={1,2,3,4,5};
        int i=array.length-1;
        recorrerArrayInversoRecursivo(array,i);
    }

    public static void recorrerArrayInversoRecursivo(int[] array, int i) {
        if (i>=0){
            System.out.println("Elemento en la posición "+i+": "+array[i]);
            recorrerArrayInversoRecursivo(array,i-1); 
        }
    }
}

