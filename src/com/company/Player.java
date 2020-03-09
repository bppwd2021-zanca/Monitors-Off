package com.company;

import java.awt.*;

public class Player {
    private int x,y,width,height;
    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(Graphics2D pen){
        pen.setColor(Color.GREEN);
        pen.fillRect(x,y,width,height);
    }
}
