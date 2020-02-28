package com.company;
import java.awt.*;
public class ProgressBar{
    private int x,y,width,height;
    private double progress;
    private int showScreen;
    public ProgressBar(int x,int y,int width,int height,double progress){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.progress=progress;
        showScreen=0;
    }public void draw(Graphics pen){
        pen.setColor(Color.gray);
        pen.fillRect(x,y,width,height);
        //
        float[] colorValues=new float[3];
        Color.RGBtoHSB((int)(255*((100-progress)/100)),(int)(255*((progress)/100)),0,colorValues);
        pen.setColor(Color.getHSBColor(colorValues[0],colorValues[1],colorValues[2]));
        pen.fillRect(x+15,y+15,(int)((width-30)*(progress/100)),height-30);
    }public void progress(double num){
        if((num>0 && progress<=100) || (num<0 && progress>=0))
            progress+=num;
        if(progress<=0);
            //color=Color.red;
    }public void update(Graphics pen,Monitor monitor,int width,int height){
        if(monitor.getState())
            progress(0.1);
        else
            progress(-0.1);
        draw(pen);
        if(progress<=0 && showScreen<=200){
            showScreen++;
            pen.setColor(Color.black);
            pen.fillRect(0,0,width,height);
            pen.setColor(Color.white);
            pen.setFont(new Font("Silom",Font.BOLD,100));
            pen.drawString("Game Over",300,300);
        }if(showScreen>=200)
            System.exit(0);
    }
}