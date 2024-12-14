/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Alfonso
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private final int WIDTH=800, HEIGHT=800;
    private Thread gameThread;
    private boolean running;
    private Ball ball;
    private Paddle player1, player2;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusCycleRoot(true);
        ball=new Ball(WIDTH/2, HEIGHT/2, 20, 20);
        player1=new Paddle(10, HEIGHT/2-60, 20, 120);
        player2=new Paddle(WIDTH-20, HEIGHT/2-60, 10, 120);
        startGame();
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
        player2.move(HEIGHT)
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        ball.draw(g);
        player1.draw(g);
        player2.draw(g);
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
