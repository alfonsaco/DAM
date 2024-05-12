package juegos;

import java.util.Scanner;

public class tresEnRaya {
    public static void main(String[] args) {
        char[][] tablero={{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        Scanner sc=new Scanner(System.in);
        boolean juegoEnCurso=true;
        while (juegoEnCurso) {
            imprimirTablero(tablero);
            tuTurno(tablero,sc);
            if (esFinJuego(tablero,'X')) {
                imprimirTablero(tablero);
                System.out.println("¡Felicidades! ¡Has ganado!");
                juegoEnCurso=false;
            } else if (esEmpate(tablero)) {
                imprimirTablero(tablero);
                System.out.println("El juego ha terminado en empate.");
                juegoEnCurso=false;
            } else {
                turnoMaquina(tablero);
                if (esFinJuego(tablero,'0')) {
                    imprimirTablero(tablero);
                    System.out.println("La máquina ha ganado. ¡Inténtalo de nuevo!");
                    juegoEnCurso=false;
                } else if (esEmpate(tablero)) {
                    imprimirTablero(tablero);
                    System.out.println("El juego ha terminado en empate.");
                    juegoEnCurso=false;
                }
            }
        }
    }

    private static void imprimirTablero(char[][] tablero) {
        System.out.println("-------------");
        for (int i=0;i<3;i++) {
            System.out.print("| ");
            for (int j=0;j<3;j++) 
                System.out.print(tablero[i][j]+" | ");
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void tuTurno(char[][] tablero, Scanner scanner) {
        int fila,columna;
        do {
        	System.out.println("Ingresa la fila (1-3):");
        	fila=scanner.nextInt()-1;
        	System.out.println("Ingresa la columna (1-3):");
        	columna=scanner.nextInt()-1;  
        } while (fila<0 || fila>=3 || columna<0 || columna>=3 || tablero[fila][columna]!=' ');
        tablero[fila][columna]='X';
    }

    private static void turnoMaquina(char[][] tablero) {
        int fila, columna;
        do {
            fila=(int)(Math.random()*3);
            columna=(int)(Math.random()*3);
        } while (tablero[fila][columna]!=' ');
        tablero[fila][columna]='0';
    }

    private static boolean esFinJuego(char[][] tablero, char jugador) {
        for (int i=0;i<3;i++) {
            if ((tablero[i][0]==jugador && tablero[i][1]==jugador && tablero[i][2]==jugador) ||
                (tablero[0][i]==jugador && tablero[1][i]==jugador && tablero[2][i]==jugador)) 
                return true;
        }
        return (tablero[0][0]==jugador && tablero[1][1]==jugador && tablero[2][2]==jugador) ||
               (tablero[0][2]==jugador && tablero[1][1]==jugador && tablero[2][0]==jugador);
    }

    private static boolean esEmpate(char[][] tablero) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (tablero[i][j]==' ') {
                    return false;
                }
            }
        }
        return true;
    }

}

