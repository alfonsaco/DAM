/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Alfonso
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private final int WIDTH=800, HEIGHT=600;
    private Thread gameThread;
    private boolean running;
    private Ball ball;
    
    // Jugadores
    private Paddle player1, player2;
    private int puntuacionJug1;
    private int puntuacionJug2;
    
    private Timer timerEspera;    
    private Image ImagenFondo;
    
    // Contador para subir velocidad
    private int contBotes=0;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        
        ball=new Ball(WIDTH/2, HEIGHT/2, 20, 20);
        player1=new Paddle(0, HEIGHT/2-60, 20, 200);
        player2=new Paddle(WIDTH-20, HEIGHT/2-60, 20, 200);
        startGame();
        
        // Timar para que haya un pequeño descanso cuando un jugador anota un punto
        timerEspera=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.setPause(false);
                ball.setContBotes(0); 
                ball.setySpeed(4);
                ball.setxSpeed(4);
                ((Timer) e.getSource()).stop();
            }
        });
        timerEspera.setRepeats(false);
        
        puntuacionJug1=0;
        puntuacionJug2=0;
        
        ImagenFondo=new ImageIcon(getClass().getResource("/pong/images/fondo.png")).getImage();
    }

    public int getPuntuacionJug1() {
        return puntuacionJug1;
    }

    public void setPuntuacionJug1(int puntuacionJug1) {
        this.puntuacionJug1 = puntuacionJug1;
    }

    public int getPuntuacionJug2() {
        return puntuacionJug2;
    }

    public void setPuntuacionJug2(int puntuacionJug2) {
        this.puntuacionJug2 = puntuacionJug2;
    }
    
    
    
    private void startGame() {
        running=true;
        gameThread=new Thread(this);
        gameThread.start();
    }
    

    @Override
    public void run() {
        while(running) {
            update();
            repaint();
            verificarDificultad();
            try {
                Thread.sleep(10);
                
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void update() {
        ball.move();
        ball.checkCollision(player1, player2, WIDTH, HEIGHT);
        player1.move(HEIGHT);
        player2.move(HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        // Imagen de fondo
        g.drawImage(ImagenFondo, 0, 0, WIDTH, HEIGHT, this);         
        
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
        
        // Dibujar las puntuaciones
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(puntuacionJug1), 30, 60);
        g.drawString(String.valueOf(puntuacionJug2), 740, 60);
    }
        
    // MÉTODO PARA CAMBIAR EL TAMAÑO DE LAS PALAS
    private void verificarDificultad() {
        if(puntuacionJug1 == 3 || puntuacionJug2 == 3 && player1.getHeight() > 100) {
            player1.setHeight(150);
            player2.setHeight(150);
        }
        if(puntuacionJug1 == 6 || puntuacionJug2 == 6 && player1.getHeight() > 70) {
            player1.setHeight(100);
            player2.setHeight(100);
        }
        if(puntuacionJug1 == 9 || puntuacionJug2 == 9) {
            player1.setHeight(70);
            player2.setHeight(70);
        }

        // Cuando se cuela la bola en uno de los dos lados, se resetea el juego, y se suma al jugador que haya marcado
        // También se aumentará la velocidad        
        if(ball.getX() <= 0 || ball.getX() >= WIDTH) {
            if(ball.getX() <= 0) {
                puntuacionJug2++;                                             
            } else {
                puntuacionJug1++;                                
            }            
            ball.setX(WIDTH/2);
            ball.setY(HEIGHT/2);
            ball.setPause(true);
                       
            timerEspera.start();
        }
    }    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            player1.setDirection(-1);
        }
        if(key == KeyEvent.VK_S) {
            player1.setDirection(1);
        }
        if(key == KeyEvent.VK_UP) {
            player2.setDirection(-1);
        }
        if(key == KeyEvent.VK_DOWN) {
            player2.setDirection(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key=e.getKeyCode();
        if(key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
            player1.setDirection(0);
        }
        if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP) {
            player2.setDirection(0);
        }
    }
    
}
