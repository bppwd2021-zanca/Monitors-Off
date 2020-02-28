package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
public class Monitor{
    private int x,y,width,height;
    private BufferedImage image;
    private boolean on;
    public Monitor(int x,int y,int width,int height,boolean on){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.on=on;
    }public void changeStates(){
        if(on){
            on=false;
        }else{
            on=true;
        }
    }public void draw(Graphics pen)throws Exception{
        if(on)
            image=ImageIO.read(new File("img/monitor_on.png"));
        else
            image=ImageIO.read(new File("img/monitor_off.png"));
        pen.drawImage(image,x,y,width,height,null);
    }public boolean getState(){
        return on;
    }
}