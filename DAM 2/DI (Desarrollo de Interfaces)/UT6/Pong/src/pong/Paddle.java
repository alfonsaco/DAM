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
public class Paddle {
    private int x, y, height, width, speed=5, direction=0;

    public Paddle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public void move(int screenHeight) {
        y+=direction*speed;
        
        if(y < 0) {
            y=0;
        }
        if(y+height > screenHeight) {
            y=screenHeight-height;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(200, 200, 200));
        g.fillRect(x, y, width, height);
    }
}
