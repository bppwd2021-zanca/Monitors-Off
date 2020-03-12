package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FiveVolt{
    private String[] moves;
    private String choice;
    private int x,y,width,height,cooldown;
    private boolean existing,screaming;
    private BufferedImage image;
    public FiveVolt(int width,int height,BufferedImage image){
        this.width=width;
        this.height=height;
        this.image=image;
        x=-3000;
        y=-3000;
        cooldown=0;
        choice="";
        screaming=false;
        moves=new String[]{"window","monitor","walking","ceiling","fade"};
    }public void update(Graphics2D pen){
        cooldown++;
        if(cooldown<350){
            existing=false;
        }
        if(cooldown==350){
            //choice=moves[(int)(Math.random()*5)];
            choice=moves[0];
            existing=true;
        }if(cooldown>=551 && cooldown<=1300 && choice.equals("window")){
            x=200;
            y=400;
            width=60;
            height=90;
            pen.drawImage(image,x,y,width,height,null);
        }if(cooldown>700 && cooldown<=1000 && choice.equals("window")){
            pen.setFont(new Font("Impact",Font.BOLD,20));
            pen.setColor(Color.white);
            pen.drawString("Monitors Off!",200,200);
            screaming=true;
        }
        if(cooldown>1000 && choice.equals("window")){
            cooldown=0;
            screaming=false;
            x=-3000;
            y=-3000;
        }
    }public boolean isScreaming(){
        return screaming;
    }
    // everytime he shows up, he says "monitors off"
    // in window (done)
    // maybe on monitor?????
    // walking by (danger zone once he's near big boys ear)
    // peak his head from the ceiling
    // fade in at random spots
}