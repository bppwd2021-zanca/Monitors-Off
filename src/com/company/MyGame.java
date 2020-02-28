package com.company;
import javax.imageio.ImageIO;
import java.awt.Color;

import java.awt.Graphics;

import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;


public class MyGame extends Game  {



    public static final String TITLE = "Monitors Off";

    public static final int SCREEN_WIDTH = 1200;

    public static final int SCREEN_HEIGHT = 800;

    public ProgressBar progressBar;

    public Monitor monitor;

    public BufferedImage desk,guy;
    public TypingMinigame typeGame;



    public MyGame() {
        typeGame = new TypingMinigame();
        progressBar=new ProgressBar(200,30,400,20,100);
        monitor=new Monitor(430,250,270,180,false);
        try{
            desk=ImageIO.read(new File("img/desk.png"));
            guy=ImageIO.read(new File("img/guy.png"));
        }catch(Exception ignored){}
    }

    public void update() {

    }



    public void draw(Graphics pen) {
        pen.setColor(Color.black);
        pen.fillRect(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        progressBar.update(pen,monitor);
        pen.drawImage(desk,365,415,400,300,null);
        try{
            monitor.draw(pen);
        }catch(Exception ignored){}
        pen.drawImage(guy,440,230,250,500,null);
        typeGame.draw(pen);

    }



    @Override

    public void keyTyped(KeyEvent ke) {}



    @Override

    public void keyPressed(KeyEvent ke) {
        typeGame.getChar(ke.getKeyChar());
        if(ke.getKeyCode()==KeyEvent.VK_SPACE)
            monitor.changeStates();
    }



    @Override

    public void keyReleased(KeyEvent ke) {}



    @Override

    public void mouseClicked(MouseEvent ke) { }



    @Override

    public void mousePressed(MouseEvent me) {

    }



    @Override

    public void mouseReleased(MouseEvent me) {}



    @Override

    public void mouseEntered(MouseEvent me) {}



    @Override

    public void mouseExited(MouseEvent me) {}
    //Launches the Game

    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }







}