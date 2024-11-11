package edu.pruebas.prc2_alfonsorincon;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BoardActivity extends AppCompatActivity {

    // Array de los botones. Como algunos son ImageButtons, y otro Buttons, no se pueden
    // almacenar en un array de Buttons, por ejemplo, por lo que los almaceno en un Array de
    // View, ya que ambos heredan de esta clase.
    private View[][] buttons;

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

    // Funciones del ActionbBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate=getMenuInflater();
        inflate.inflate(R.menu.new_menu, menu);
        getMenuInflater().inflate(R.menu.new_menu, menu);
        return true;
    }

    // Método para definir la dificultad del juego. Por defecto, se inicia en Easy
    private void setDifficulty(String difficulty) {
        switch (difficulty) {
            case "easy":
                int[][] board=locateMines(16,16,60);
                printBoard(board);
                createGrid(board ,16);
                break;

            case "medium":

                break;

            case "hard":

                break;
        }
    }

    // Método para crear el grid mediante el array de números
    private void createGrid(int[][] board, int gridSize) {
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        gridLayout.setRowCount(gridSize);
        gridLayout.setColumnCount(gridSize);

        // Definir el tamaño del botón
        //      getDisplayMetrics(): contiene información sobre la pantalla del dispositivo
        //      widthPixels: devuelve el ancho en píxeles
        int buttonSize=getResources().getDisplayMetrics().widthPixels / gridSize;
        buttons=new View[gridSize][gridSize];

        for (int i=0; i<board.length; i++) {
            for (int e=0; e<board[i].length; e++) {
                if(board[i][e] == -1) {
                    ImageButton button=new ImageButton(this);

                    // Configuración básica para ambos tipos de botón
                    button.setLayoutParams(new GridLayout.LayoutParams());
                    button.getLayoutParams().width = buttonSize;
                    button.getLayoutParams().height = buttonSize;

                    // Guardar el botón en el array de View
                    buttons[i][e] = button;

                    // Configurar comportamiento al hacer clic
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Acción al hacer clic en la casilla
                            if (v instanceof ImageButton) {
                                // Acciones para la mina
                            } else if (v instanceof Button) {
                                // Acciones para una casilla normal
                            }
                        }
                    });

                    // Añadir el botón al GridLayout
                    gridLayout.addView(button);
                } else {
                    Button button=new Button(this);

                    // Configuración básica para ambos tipos de botón
                    button.setLayoutParams(new GridLayout.LayoutParams());
                    button.getLayoutParams().width = buttonSize;
                    button.getLayoutParams().height = buttonSize;

                    // Guardar el botón en el array de View
                    buttons[i][e] = button;

                    // Configurar comportamiento al hacer clic
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Acción al hacer clic en la casilla
                            if (v instanceof ImageButton) {
                                // Acciones para la mina
                            } else if (v instanceof Button) {
                                // Acciones para una casilla normal
                            }
                        }
                    });

                    // Añadir el botón al GridLayout
                    gridLayout.addView(button);
                }
            }
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
    private int[][] locateMines(int widht, int height, int minesNumber) {
        int[][] board=new int[widht][height];

        // Método para insertar minas en el tablero de forma aleatoria
        int contMines=0;
        int random;
        do {
            for (int i=0; i<board.length; i++) {
                for (int e=0; e<board[i].length; e++) {
                    random=(int) (Math.random()*15);
                    // Verificar que en la posición en cuestión, no haya una mina ya. Si el random es
                    // 5, se colocará una mina.
                    if(random==5 && board[i][e]!=-1 && contMines<minesNumber) {
                        contMines++;
                        board[i][e]=-1;
                    }
                }
            }

        } while(contMines < minesNumber);

        // Situar los números
        for (int i=0; i<board.length; i++) {
            for (int e=0; e<board[i].length; e++) {
                if(board[i][e]!=-1) {
                    // Verificar mina de arriba
                    if(i>0 && board[i-1][e]==-1) {
                        board[i][e]++;
                    }
                    // Verificar mina de abajo
                    if(i<board.length-1 && board[i+1][e]==-1) {
                        board[i][e]++;
                    }
                    // Verificar mina de la izquierda
                    if(e>0 && board[i][e-1]==-1) {
                        board[i][e]++;
                    }
                    // Verificar mina de la derecha
                    if(e<board[i].length-1 && board[i][e+1]==-1) {
                        board[i][e]++;
                    }
                    // Verificar arriba izquierda
                    if(i>0 && e>0 && board[i-1][e-1]==-1) {
                        board[i][e]++;
                    }
                    // Verificar arriba derecha
                    if(i>0 && e<board[i].length-1 && board[i-1][e+1]==-1) {
                        board[i][e]++;
                    }
                    // Verificar abajo izquierda
                    if(i<board.length-1 && e>0 && board[i+1][e-1]==-1) {
                        board[i][e]++;
                    }
                    // Verificar abajo derecha
                    if(i<board.length-1 && e<board[i].length-1 && board[i+1][e+1]==-1) {
                        board[i][e]++;
                    }
                }
            }
        }

        return board;
    }


}