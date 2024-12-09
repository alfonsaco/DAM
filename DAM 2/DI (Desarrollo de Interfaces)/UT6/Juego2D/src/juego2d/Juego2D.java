package juego2d;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Juego2D extends JFrame {

    private JuegoPanel panel;   

    public Juego2D() {
        panel=new JuegoPanel();
        this.setIconImage(new ImageIcon(getClass().getResource("/juego2d/images/logo.png")).getImage());
        
        add(panel);  
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
    
    // Imágenes
    private Image imagenFondo;
    private Image imagenCoche;
    private Image imagenEdificio;
    private Image imagenMoneda;
    // Ángulo de rotación del coche
    private double angulo=0;
    
    // Variables del bloque verde
    private int Xbloque1, Ybloque2;
    
    // Monedas
    private ArrayList<Moneda> monedas;
    private int contMonedas=0;

    public JuegoPanel() {        
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new TAdapter());
        
        imagenFondo=new ImageIcon(getClass().getResource("/juego2d/images/mapa.jpg")).getImage();
        imagenCoche=new ImageIcon(getClass().getResource("/juego2d/images/coche.png")).getImage();
        imagenEdificio=new ImageIcon(getClass().getResource("/juego2d/images/edificio.png")).getImage();
        imagenMoneda=new ImageIcon(getClass().getResource("/juego2d/images/token.png")).getImage();

        // Posición y velocidad del cubo rojo
        x = 45;
        y = 45;
        velX = 0;
        velY = 0;

        // Posición del bloque verde
        Xbloque1 = 490;
        Ybloque2 = 330;
        
        timer = new Timer(10, this);
        timer.start();                
        
        // Añadir las monedas al ArrayList
        monedas=new ArrayList<>();
        monedas.add(new Moneda(205, 100));
        monedas.add(new Moneda(300, 395));
        monedas.add(new Moneda(640, 510));
        monedas.add(new Moneda(640, 200));
        monedas.add(new Moneda(140, 300));
    }
    
    private void dibujarMonedas(Graphics g) {
        for(Moneda m : monedas) {
            if(!m.recogida) {
                g.drawImage(imagenMoneda, m.x, m.y, 20, 20, this);
            }
        }   
    }

    // Pintar el cubo y el bloque
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el fondo
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);        
        dibujar(g); 
        
        // Llamamos a dibujar las monedas
        dibujarMonedas(g);
    }

    private void dibujar(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        AffineTransform  originalTransform = g2d.getTransform();
        
        // DIBUJO DEL COCHE
        g2d.translate(x + 20, y + 12.5);
        g2d.rotate(angulo);
        g2d.drawImage(imagenCoche, -20, -12, 40, 25, this);

        // Con esta línea, evitamos que el edificio se mueva junto con el coche
        g2d.setTransform(originalTransform);
        
        // Dibujar el bloque verde
        g.drawImage(imagenEdificio, Xbloque1, Ybloque2, 150, 180, this);
        
        // COntador de monedas recogidas
        g.setColor(Color.BLACK);
        g.fillRect(getWidth()-50, 0, 100, 40);    
        // Borde del cuadrado
        g.setColor(Color.WHITE);
        g.drawRect(getWidth()-50, 0, 100, 40);
        // Números del contador
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(String.valueOf(contMonedas), getWidth()-30, 30);
        
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

        // Colisión con los bordes de la pantalla
        if (newX < 0) newX = 0;
        if (newX > getWidth() - 30) newX = getWidth() - 30;
        if (newY < 0) newY = 0;
        if (newY > getHeight() - 30) newY = getHeight() - 30;

        // Verificar colisión con el bloque
        if (isCollisionWithBlock(newX, newY)) {
            // Detectar lado de colisión basado en la posición previa y dirección
            if (x + 30 <= Xbloque1 && velX > 0) { // Lado izquierdo del bloque
                newX = Xbloque1 - 30;
            } else if (x >= Xbloque1 + 100 && velX < 0) { // Lado derecho del bloque
                newX = Xbloque1 + 100;
            }

            if (y + 30 <= Ybloque2 && velY > 0) { // Parte superior del bloque
                newY = Ybloque2 - 30;
            } else if (y >= Ybloque2 + 100 && velY < 0) { // Parte inferior del bloque
                newY = Ybloque2 + 100;
            }

            // Si colisión en ambas direcciones, ajustamos la que tiene mayor desplazamiento
            if (isCollisionWithBlock(newX, newY)) {
                if (Math.abs(velX) > Math.abs(velY)) {
                    newX = x; // Ignoramos el movimiento horizontal
                } else {
                    newY = y; // Ignoramos el movimiento vertical
                }
            }
        }
        
        for(Moneda moneda : monedas) {
            if(!moneda.recogida && isCollisionWithMoneda(newX, newY, moneda)) {
                moneda.setRecogida(true);
                contMonedas++;                
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
        int bloqueWidth = 150;
        int bloqueHeight = 180;

        // Comprobamos si el cubo rojo se superpone con el bloque verde
        return newX < bloqueX + bloqueWidth && newX + 30 > bloqueX &&
               newY < bloqueY + bloqueHeight && newY + 30 > bloqueY;
    }
    
    private boolean isCollisionWithMoneda(int jugadorX, int jugadorY, Moneda moneda) {
        return jugadorX < moneda.getX() + 15 && jugadorX + 30 > moneda.getX() &&
               jugadorY < moneda.getY() + 15 && jugadorY + 30 > moneda.getY();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                velX=-2;
                velY=0;
                angulo=Math.toRadians(0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                velX=2;
                velY=0;
                angulo=Math.toRadians(180);
            }

            if (key == KeyEvent.VK_UP) {
                velX=0;
                velY=-2;
                angulo=Math.toRadians(90);
            }

            if (key == KeyEvent.VK_DOWN) {
                velX=0;
                velY=2;
                angulo=Math.toRadians(-90);
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
    
    // CLASE QUE REPRESENTA LA MONEDA
    class Moneda {
        private int x;
        private int y;
        private boolean recogida;

        public Moneda(int x, int y) {
            this.x = x;
            this.y = y;
            this.recogida = false;
        }

        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public boolean isRecogida() {
            return recogida;
        }
        public void setRecogida(boolean recogida) {
            this.recogida = recogida;
        }                        
    }
}
