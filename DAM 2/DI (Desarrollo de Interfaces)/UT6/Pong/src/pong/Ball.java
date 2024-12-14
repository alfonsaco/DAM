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
    private int xSpeed=3, ySpeed=3;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void move() {
        x+=xSpeed;
        y+=ySpeed;
    }
    
    public void checkCollision(Paddle p1, Paddle p2, int screenWidth, int screenHeight) {
        if(y  <= 0 || y+height >= screenHeight) {
            ySpeed*=-1;
        }
        if(x <= p1.getX()+p1.getWidth() && y+height >= p1.getY() && y <= p1.getY()+p1.getHeight()) {
            xSpeed*=-1;
        }
        if(x+width >= p2.getX() && y+height >= p2.getY() && y <= p2.getY()+p2.getHeight()) {
            xSpeed*=-1;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(new Color(200, 200, 200));
        g.fillOval(x, x, width, height);
    }
}
