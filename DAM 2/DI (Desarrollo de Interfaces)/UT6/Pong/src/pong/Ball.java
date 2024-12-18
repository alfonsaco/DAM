/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Alfonso
 */
public class Ball {
    private int x, y, width, height;
    private int xSpeed=4, ySpeed=4;
    private boolean pause;
    
    private int contBotes=0;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isPause() {
        return pause;
    }
    public void setPause(boolean pause) {
        this.pause = pause;
    }       
    public int getContBotes() {
        return contBotes;
    }
    public void setContBotes(int contBotes) {
        this.contBotes = contBotes;
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
    public int getxSpeed() {
        return xSpeed;
    }
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    public int getySpeed() {
        return ySpeed;
    }
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }        
    
    public void move() {
        if(!pause) {
            x+=xSpeed;
            y+=ySpeed;   
        }
    }
    
    public void checkCollision(Paddle p1, Paddle p2, int screenWidth, int screenHeight) {
        if(y  <= 0 || y+height >= screenHeight) {
            ySpeed*=-1;
        }      

        // Casos en los que la bola llega al final de la pantalla. Un jugador gana un punto
        if(x <= p1.getX()+p1.getWidth() && y+height >= p1.getY() && y <= p1.getY()+p1.getHeight()) {
            xSpeed*=-1;
            contBotes++;
            cambiarVelocidad();
        }
        if(x+width >= p2.getX() && y+height >= p2.getY() && y <= p2.getY()+p2.getHeight()) {
            xSpeed*=-1;
            contBotes++;
            cambiarVelocidad();
        }       
    }
    
    // Utilizamos el contBotes para aumentar la velocidad cada cierto número de botes con las palas
    private void cambiarVelocidad() {
        int velX=getxSpeed();
        int velY=getySpeed();
        
        if(contBotes > 0 || contBotes%4 == 0) {
            setxSpeed(velX + (velX > 0 ? 1 : -1));
            setySpeed(velY + (velY > 0 ? 1 : -1));
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(new Color(200, 200, 200));
        g.fillOval(x, y, width, height);
    }
}
