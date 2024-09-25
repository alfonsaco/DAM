package arraysUnidimensionales;

public class InvertirArray {

	public static void main(String[] args) {
		int[]numerosAleatorios=new int[20];
        generarNumerosAleatorios(numerosAleatorios);
        mostrarArrayOriginal(numerosAleatorios);
        System.out.println();
        mostrarArrayInverso(numerosAleatorios);
	}
	
	private static void generarNumerosAleatorios(int[] numerosAleatorios) {
        for (int i=0;i<numerosAleatorios.length;i++) 
            numerosAleatorios[i]=(int)(Math.random()*50)+ 1;
    }

    private static void mostrarArrayOriginal(int[] numerosAleatorios) {
    	System.out.print("Array original: ");
        for (int i=0;i<numerosAleatorios.length;i++) 
            System.out.print(numerosAleatorios[i]+" ");
    }

    private static void mostrarArrayInverso(int[] numerosAleatorios) {
    	System.out.print("Array invertido: ");
        for (int i=numerosAleatorios.length-1;i>=0;i--) 
            System.out.print(numerosAleatorios[i]+" ");
    }

}
