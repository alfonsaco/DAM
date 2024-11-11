package edu.pruebas.prc2_alfonsorincon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tablero);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setDifficulty("easy");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    // Método para definir la dificultad del juego. Por defecto, se inicia en Easy
    private void setDifficulty(String difficulty) {
        switch (difficulty) {
            case "easy":
                int[][] board=locateMines(10);
                printBoard(board);
                break;

            case "medium":

                break;

            case "hard":

                break;
        }
    }

    // Método para leer el Array completo y mostrarlo por consola
    private void printBoard(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int e=0; e<board[i].length; e++) {
                System.out.print(board[i][e]+" ");
            }
            System.out.print("\n");
        }
    }

    // Método para situar las minas de forma aleatoria a lo largo del Grid
    private int[][] locateMines(int minesNumber) {
        int[][] board=new int[8][8];

        // Para llenar el Array de 0
        for (int i=0; i<board.length; i++) {
            for (int e=0; e<board[i].length; e++) {
                board[i][e]=0;
            }
        }

        // Método para insertar minas en el tablero de forma aleatoria
        int contMines=0;
        int random;
        do {
            for (int i=0; i<board.length; i++) {
                for (int e=0; e<board[i].length; e++) {
                    random=(int) (Math.random()*15);
                    // Verificar que en la posición en cuestión, no haya una mina ya
                    if(random==5 && board[i][e]!=-1 && contMines<minesNumber) {
                        contMines++;
                        board[i][e]=-1;
                    }
                }
            }

        } while(contMines < minesNumber);

        return board;
    }
}