package arraysUnidimensionales;

import java.util.Arrays;

public class GordoPrimitiva {

    public static void main(String[] args) {
        int[] bloque1=new int[5];
        int bloque2=generarNumeroAleatorio(0, 9);
        generarBloque1(bloque1);
        Arrays.sort(bloque1); 
        mostrarApuesta(bloque1,bloque2);
    }

    public static void generarBloque1(int[] bloque1) {
        for (int i=0;i<bloque1.length;i++) {
            bloque1[i]=generarNumeroAleatorio(1,54);
            while (existeEnBloque1(bloque1,i,bloque1[i])) 
                bloque1[i]=generarNumeroAleatorio(1,54);
        }
    }

    public static boolean existeEnBloque1(int[] bloque1, int indice, int numero) {
        for (int i=0;i<indice;i++) {
            if (bloque1[i]==numero) {
                return true;
            }
        }
        return false;
    }

    public static int generarNumeroAleatorio(int min, int max) {
        return (int)(Math.random()*(max-min+1))+min;
    }

    public static void mostrarApuesta(int[] bloque1, int bloque2) {
    	System.out.println("Bloque 1:");
        for (int i=0;i<bloque1.length;i++) {
            System.out.print(bloque1[i]);
            if (i<bloque1.length-1) 
                System.out.print("  ");
        }
        System.out.println("\nBloque 2:\n"+bloque2);
    }
}
