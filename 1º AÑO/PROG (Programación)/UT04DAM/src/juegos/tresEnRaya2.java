package juegos;
import java.util.Scanner;

public class tresEnRaya2 {

    public static void main(String[] args) {
        String[][] t = new String[3][3];
        crearTablero(t); // inicializa las casillas a " "
        mostrarTablero(t);
        String jugador = "X";
        int x, y;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Turno del jugador " + jugador);
            System.out.print("Ingrese la posición x: ");
            x = sc.nextInt();
            System.out.print("Ingrese la posición y: ");
            y = sc.nextInt();
            if (colocaFicha(jugador, x, y, t) == 0) {
                mostrarTablero(t);
                if (gana(jugador, t)) {
                    System.out.println("¡El jugador " + jugador + " ha ganado!");
                    break;
                }
                if (hayHuecos(t)) {
                    jugador = (jugador.equals("X")) ? "O" : "X";
                    if (jugador.equals("O")) {
                        if (juegaPC(t) == 0) {
                            mostrarTablero(t);
                            if (gana("O", t)) {
                                System.out.println("¡El PC ha ganado!");
                                break;
                            }
                            if (!hayHuecos(t)) {
                                System.out.println("¡Empate!");
                                break;
                            }
                        } else {
                            System.out.println("Ocurrió un error al jugar el PC.");
                            break;
                        }
                    }
                } else {
                    System.out.println("¡Empate!");
                    break;
                }
            } else {
                System.out.println("Posición inválida, inténtelo de nuevo.");
            }
        } while (true);
    }

    public static void crearTablero(String[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = " ";
            }
        }
    }

    public static void mostrarTablero(String[][] t) {
        System.out.println("*************");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print("| " + t[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("_____________");
        }
        System.out.println("*************");
    }

    private static int colocaFicha(String jugador, int x, int y, String[][] t) {
        if (x >= 0 && x < t.length && y >= 0 && y < t[0].length && t[x][y].equals(" ")) {
            t[x][y] = jugador;
            return 0;
        } else {
            return -1;
        }
    }

    private static int juegaPC(String[][] t) {
        if (hayHuecos(t)) {
            int x, y;
            do {
                x = (int) (Math.random() * 3);
                y = (int) (Math.random() * 3);
            } while (!t[x][y].equals(" "));
            t[x][y] = "O";
            return 0;
        } else {
            return -1;
        }
    }

    private static boolean gana(String jugador, String[][] t) {
        return compruebaHorizontal(jugador, t) || compruebaVertical(jugador, t) || compruebaDiagonal(jugador, t);
    }

    private static boolean hayHuecos(String[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean compruebaHorizontal(String jugador, String[][] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i][0].equals(jugador) && t[i][1].equals(jugador) && t[i][2].equals(jugador)) {
                return true;
            }
        }
        return false;
    }

    private static boolean compruebaVertical(String jugador, String[][] t) {
        for (int i = 0; i < t[0].length; i++) {
            if (t[0][i].equals(jugador) && t[1][i].equals(jugador) && t[2][i].equals(jugador)) {
                return true;
            }
        }
        return false;
    }

    private static boolean compruebaDiagonal(String jugador, String[][] t) {
        return (t[0][0].equals(jugador) && t[1][1].equals(jugador) && t[2][2].equals(jugador)) ||
                (t[0][2].equals(jugador) && t[1][1].equals(jugador) && t[2][0].equals(jugador));
    }
}
