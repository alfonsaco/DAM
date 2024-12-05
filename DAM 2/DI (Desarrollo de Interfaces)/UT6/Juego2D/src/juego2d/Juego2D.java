package juego2d;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class Juego2D extends JFrame {

    private JuegoPanel panel;

    public Juego2D() {
        panel = new JuegoPanel();
        add(panel);  // Añadir el panel principal al JFrame
        setTitle("Juego 2D");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        Juego2D juego = new Juego2D();
        juego.setVisible(true);
    }
}

class JuegoPanel extends JPanel implements ActionListener {

    private Timer timer;
    private int x, y, velX, velY;
    
    // Variables del bloque verde
    private int Xbloque1, Ybloque2;

    public JuegoPanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new TAdapter());

        // Posición y velocidad del cubo rojo
        x = 50;
        y = 50;
        velX = 0;
        velY = 0;

        // Posición del bloque verde
        Xbloque1 = 200;
        Ybloque2 = 300;
        
        timer = new Timer(10, this);
        timer.start();                
    }

    // Pintar el cubo y el bloque
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g);  // Llamamos al método para dibujar los objetos
    }

    private void dibujar(Graphics g) {
        // Dibujar el cubo rojo
        g.setColor(Color.RED);
        g.fillRect(x, y, 30, 30);
        
        // Dibujar el bloque verde
        g.setColor(Color.GREEN);
        g.fillRect(Xbloque1, Ybloque2, 100, 100);
    }

    // Mover el cubo y redibujar la pantalla
    @Override
    public void actionPerformed(ActionEvent e) {
        mover();
        repaint();
    }

    private void mover() {
        // Mover el cubo
        int newX = x + velX;
        int newY = y + velY;

        // Colisión con los bordes
        if (newX < 0) newX = 0;
        if (newX > getWidth() - 30) newX = getWidth() - 30;
        if (newY < 0) newY = 0;
        if (newY > getHeight() - 30) newY = getHeight() - 30;

        // Verificar colisión con el bloque
        if (isCollisionWithBlock(newX, newY)) {
            // Si hay colisión, ajustamos la posición para evitar que atraviese
            if (velX > 0) { // Si va a la derecha
                newX = Xbloque1 - 30;
            } else if (velX < 0) { // Si va a la izquierda
                newX = Xbloque1 + 100;
            }

            if (velY > 0) { // Si va hacia abajo
                newY = Ybloque2 - 30;
            } else if (velY < 0) { // Si va hacia arriba
                newY = Ybloque2 + 100;
            }
        }

        // Actualizamos la posición final
        x = newX;
        y = newY;
    }

    // Método que detecta si el cubo rojo colide con el bloque verde
    private boolean isCollisionWithBlock(int newX, int newY) {
        // Coordenadas y tamaño del bloque verde
        int bloqueX = Xbloque1;
        int bloqueY = Ybloque2;
        int bloqueWidth = 100;
        int bloqueHeight = 100;

        // Comprobamos si el cubo rojo se superpone con el bloque verde
        return newX < bloqueX + bloqueWidth && newX + 30 > bloqueX &&
               newY < bloqueY + bloqueHeight && newY + 30 > bloqueY;
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                velX = -2;
            }

            if (key == KeyEvent.VK_RIGHT) {
                velX = 2;
            }

            if (key == KeyEvent.VK_UP) {
                velY = -2;
            }

            if (key == KeyEvent.VK_DOWN) {
                velY = 2;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                velX = 0;
            }

            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
                velY = 0;
            }
        }
    }
}
