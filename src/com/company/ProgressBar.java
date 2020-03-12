package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ProgressBar{
    private int x,y,width,height;
    private double progress;
    private int showScreen;
    private BufferedImage image;
    public ProgressBar(int x,int y,int width,int height,double progress){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.progress=progress;
        showScreen=0;
        try {
            image= ImageIO.read(new File("img/funny.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }public void draw(Graphics2D pen){
        pen.setColor(Color.gray);
        pen.fillRect(x,y,width,height);
        //
        float[] colorValues=new float[3];
        if(progress>=50)
            Color.RGBtoHSB((int)(255*(100-(progress*2))/100),255,0,colorValues);
        if(progress>=50 && progress<51)
            Color.RGBtoHSB(255,255,0,colorValues);
        if(progress<50)
            Color.RGBtoHSB(255,(int)(255*(progress/50)),0,colorValues);
        pen.setColor(Color.getHSBColor(colorValues[0],colorValues[1],colorValues[2]));
        pen.fillRect(x+15,y+15,(int)((width-30)*(progress/100)),height-30);
        pen.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        pen.setColor(Color.white);
        pen.drawString("Focus Level",x+130,y-10);
    }public void progress(double num){
        if((num>0 && progress<=100) || (num<0 && progress>=0))
            progress+=num;
        if(progress<=0);
            //color=Color.red;
    }public void update(Graphics2D pen,Monitor monitor,int width,int height){
        if(monitor.getState())
            progress(0.08);
        else
            progress(-0.1);
        draw(pen);
        float o=(float)(1-(progress/100));
        AlphaComposite ac;
        if(progress>=0 && progress<=100){
            ac=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,o);
            pen.setComposite(ac);
            if(!monitor.getState())
                pen.drawImage(image,490,220,70,100,null);
        }
        if(progress<=0 && showScreen<=200){
            showScreen++;
            if(monitor.getState())
                monitor.changeStates();
            pen.setColor(Color.black);
            pen.fillRect(0,0,width,height);
            pen.setColor(Color.white);
            pen.setFont(new Font("Silom",Font.BOLD,30));
            pen.drawString("Uh Oh! You've lost focus!",380,720);
            pen.drawImage(image,370,60,400,600,null);
        }if(showScreen>=200)
            System.exit(0);
    }public int getShowScreen(){
        return showScreen;
    }public void decBar(){
        progress-=20;
    }
}