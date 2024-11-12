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
/*
    // Método para definir la dificultad del juego. Por defecto, se inicia en Easy
    public void seleccionarDificultad(String difficulty) {
        switch (difficulty) {
            case "facil":
                int[][] array=tablero.situarMinas(16,16,60);
                tablero.imprimirTablero(array);
                tablero.crearTablero(array ,16);
                break;

            case "medio":

                break;

            case "avanzado":

                break;
        }
    }*/
}
