package juegos;

import java.util.Scanner;

public class buscaTesoro {

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        int intentos=0;
        int filas=4;
        int columnas=5;
        char[][] cuadrante=new char[4][5];
        boolean encontrado=false;
        boolean tocadoMina=false;
        inicializarCuadrante(cuadrante,filas,columnas);
        // Colocar Mina
        int filaMina=(int)(Math.random()*filas);
        int columnaMina=(int)(Math.random()*columnas);
        int filaTesoro,columnaTesoro;
        cuadrante[filaMina][columnaMina]='M';
        // Colocar Tesoro
        do {
        	filaTesoro=(int)(Math.random()*filas);
        	columnaTesoro=(int)(Math.random()*columnas);
        }while((filaMina==filaTesoro) && (columnaMina==columnaTesoro));
        cuadrante[filaTesoro][columnaTesoro]='T';
        mostrarCuadrante(cuadrante);
        // Empieza el juego
        // System.out.println("La posición del tesoro es: ["+filaTesoro+","+columnaTesoro+"]");
        // System.out.println("La posición de la mina es: ["+filaMina+","+columnaMina+"]");
        while (intentos<5 && !encontrado && !tocadoMina) {
            System.out.print("Introduce la fila (0-"+(filas-1)+"): ");
            int filaUsuario=sc.nextInt();
            System.out.print("Introduce la columna (0-"+(columnas-1)+"): ");
            int columnaUsuario=sc.nextInt();
            if (filaUsuario>=0 && filaUsuario<filas && columnaUsuario>=0 && columnaUsuario<columnas) {
                intentos++;
                if (filaUsuario==filaMina && columnaUsuario==columnaMina) {
                    tocadoMina=true;
                    System.out.println("¡Boom! ¡Has tocado una mina! Has perdido el juego.");
                } else if (filaUsuario==filaTesoro && columnaUsuario==columnaTesoro) {
                    encontrado=true;
                    System.out.println("¡Encontraste el tesoro! ¡Felicidades!");
                } else 
                    System.out.println("¡Oops! No encontraste el tesoro. Sigue intentándolo.");
            } else 
                System.out.println("Por favor, introduce coordenadas válidas.");
        }
        if (intentos>=5) 
            System.out.println("¡Agotaste tus 5 intentos! El tesoro sigue oculto.");
        sc.close();
    }

    // Método para inicializar el cuadrante
	private static void inicializarCuadrante(char[][] cuadrante, int filas, int columnas) {
    	for (int i=0;i<filas;i++) {
            for (int j=0;j<columnas;j++) 
                cuadrante[i][j]='*';
        }
	}

	// Método para mostrar el cuadrante sin revelar la posición de la mina y el tesoro
    private static void mostrarCuadrante(char[][] cuadrante) {
        for (int i=0;i<cuadrante.length;i++) {
            for (int j=0;j<cuadrante[i].length;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

