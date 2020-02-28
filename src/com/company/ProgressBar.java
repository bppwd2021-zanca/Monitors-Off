package com.company;
import java.awt.*;
public class ProgressBar{
    private int x,y,width,height,progress;
    public ProgressBar(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        progress=0;
    }public void draw(Graphics pen){
        pen.setColor(Color.white);
        pen.fillRect(x,y,width,height);
        pen.fillRect(x+15,y+15,,height-30);
    }
}