package juegos;

import java.util.Arrays;
import java.util.Scanner;

public class piedraPapelTijera {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de Piedra, Papel o Tijera!");
        boolean continuarJugando=true;
        char[] resultadosUsuario=new char[5];
        char[] resultadosMaquina=new char[5];
        for (int i=0;i<5 && continuarJugando;i++) {
            System.out.println("Elige tu jugada:");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijera"); 
            System.out.println("4. Salir");
            if (sc.hasNextInt()) {
                int jugadaUsuario=sc.nextInt();
                sc.nextLine(); 
                if (jugadaUsuario>=1 && jugadaUsuario<=3) {
                    int jugadaMaquina=generarJugadaMaquina();
                    mostrarJugadas(jugadaUsuario,jugadaMaquina);
                    determinarGanador(jugadaUsuario,jugadaMaquina,resultadosUsuario,resultadosMaquina,i);
                } else if (jugadaUsuario==4){
                    System.out.println("¡Gracias por jugar! Fin de la partida.");
                    continuarJugando=false;
                }else 
                    System.out.println("Por favor, introduce un número válido.");
            } else {
                String input = sc.nextLine().toLowerCase();
                if (input.equals("salir")) {
                    System.out.println("¡Gracias por jugar! Fin de la partida.");
                    continuarJugando = false;
                } else 
                    System.out.println("Por favor, introduce un número válido.");
            }
        }
        // Muestra el resumen al finalizar las partidas
        mostrarResumen(resultadosUsuario,resultadosMaquina);
        sc.close();
    }
    
    // Método que genera un número aleatorio entre 1 y 3
    private static int generarJugadaMaquina() {
        return (int)(Math.random()*3)+1;
    }
    
    // Método para mostrar el resultado de la jugada
    private static void mostrarJugadas(int jugadaUsuario, int jugadaMaquina) {
        System.out.println("Tu jugada: "+getNombreJugada(jugadaUsuario));
        System.out.println("Jugada de la máquina: "+getNombreJugada(jugadaMaquina));
    }

    // Método para determinar quien gana
    private static void determinarGanador(int jugadaUsuario,int jugadaMaquina,char[] resultadosUsuario,char[] resultadosMaquina,int indice) {
    	 // EMPATE
    	if (jugadaUsuario==jugadaMaquina) {
            System.out.println("¡Empate!");
            resultadosUsuario[indice]='X';
            resultadosMaquina[indice]='X';
        // USUARIO GANA
        } else if ((jugadaUsuario==1 && jugadaMaquina==3) || //Piedra gana a Tijera
                (jugadaUsuario==2 && jugadaMaquina==1) || // Papel gana a Piedra
                (jugadaUsuario==3 && jugadaMaquina==2)) { // Tijera gana a Papel
            System.out.println("¡Ganaste!");
            resultadosUsuario[indice]='1';
            resultadosMaquina[indice]='0';
         // MÁQUINA GANA
        } else {
            System.out.println("¡Perdiste!");
            resultadosUsuario[indice]='0';
            resultadosMaquina[indice]='1';
        }
    }

    // Método para mostrar el resultado final de la partida
    private static void mostrarResumen(char[] resultadosUsuario, char[] resultadosMaquina) {
        System.out.println("\nResumen de Partidas:");
        System.out.println("Usuario: "+Arrays.toString(resultadosUsuario));
        System.out.println("Máquina: "+Arrays.toString(resultadosMaquina));
    }

    // Método para escoger la jugada
    private static String getNombreJugada(int numeroJugada) {
        switch (numeroJugada) {
            case 1:
                return "Piedra";
            case 2:
                return "Papel";
            case 3:
                return "Tijera";
            default:
                return "Desconocida";
        }
    }
    
}