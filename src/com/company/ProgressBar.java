package com.company;
import java.awt.*;
public class ProgressBar{
    private int x,y,width,height;
    private double progress;
    public ProgressBar(int x,int y,int width,int height,double progress){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.progress=progress;
    }public void draw(Graphics pen){
        pen.setColor(Color.gray);
        pen.fillRect(x,y,width,height);
        float[] colorValues=new float[3];
        Color.RGBtoHSB((int)(255*((100-progress)/100)),(int)(255*((progress)/100)),0,colorValues);
        pen.setColor(Color.getHSBColor(colorValues[0],colorValues[1],colorValues[2]));
        pen.fillRect(x+15,y+15,(int)((width-30)*(progress/100)),height-30);
    }public void progress(double num){
        if((num>0 && progress<=100) || (num<0 && progress>=0))
            progress+=num;
        if(progress<=0);
            //color=Color.red;
    }public void update(Graphics pen,double progress){
        progress(progress);
        draw(pen);
    }
}