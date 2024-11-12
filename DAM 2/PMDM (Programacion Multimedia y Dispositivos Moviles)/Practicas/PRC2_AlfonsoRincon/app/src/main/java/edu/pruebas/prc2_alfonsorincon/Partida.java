package edu.pruebas.prc2_alfonsorincon;

public class Partida {
    public int puntos;
    private Tablero tablero;

    // Constructor
    public Partida(int puntos) {
        this.puntos = puntos;
        this.tablero=new Tablero();
    }
    public Partida() {
        this.tablero=new Tablero();
    }

    // Getters y Setters
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Método para definir la dificultad del juego. Por defecto, se inicia en Easy
    public void comenzar(int x, int y, int minas) {
        int[][] array=tablero.establecerMinas(x,y,minas);
        tablero.imprimirTablero(array);
                //tablero.crearTablero(array ,16);

    }
}
