package com.company;
import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MyGame extends Game  {



    public static final String TITLE = "Monitors Off";

    public static final int SCREEN_WIDTH = 1200;

    public static final int SCREEN_HEIGHT = 800;

    public ProgressBar progressBar;

    public Monitor monitor;

    public BufferedImage desk,guy,guy2,bgImage;

    private TypingMinigame typeGame;


    public MyGame() throws IOException {
        typeGame = new TypingMinigame();
        progressBar=new ProgressBar(365,30,400,20,100);
        monitor=new Monitor(430,250,270,180,false);
        try{
            desk=ImageIO.read(new File("img/desk.png"));
            guy=ImageIO.read(new File("img/guy.png"));
            guy2=ImageIO.read(new File("img/guy3.png"));
            bgImage=ImageIO.read(new File("img/bg.png"));
        }catch(Exception ignored){}
    }

    public void update() {

    }



    public void draw(Graphics2D pen) {
        pen.setColor(Color.black);
        //pen.fillRect(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        pen.drawImage(bgImage,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,null);
        pen.drawImage(desk,365,415,400,300,null);
        if(typeGame.hasFailed()){
            progressBar.decBar();
            typeGame.reset();
        }if(monitor.getState())
            typeGame.draw(pen);
        else
            typeGame.reset();
        try{
            monitor.draw(pen);
        }catch(Exception ignored){}
        if(monitor.getState())
            pen.drawImage(guy,440,230,250,500,null);
        else
            pen.drawImage(guy2,440,230,250,500,null);
        progressBar.update(pen,monitor,SCREEN_WIDTH,SCREEN_HEIGHT);
    }



    @Override

    public void keyTyped(KeyEvent ke) {}



    @Override

    public void keyPressed(KeyEvent ke) {

        if(ke.getKeyCode()==KeyEvent.VK_BACK_SPACE)
            typeGame.backspace();
        else
            typeGame.getChar(ke.getKeyChar());
    }



    @Override

    public void keyReleased(KeyEvent ke) {}



    @Override

    public void mouseClicked(MouseEvent ke) { }



    @Override

    public void mousePressed(MouseEvent me) {
        double mouseX= MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY=MouseInfo.getPointerInfo().getLocation().getY();
        int frameX=getWindowX();
        int frameY=getWindowY();
        if(mouseX>=frameX+681 && mouseX<=frameX+698 && mouseY>=frameY+431 && mouseY<=frameY+443)
            if(progressBar.getShowScreen()==0)
                monitor.changeStates();
    }



    @Override

    public void mouseReleased(MouseEvent me) {}



    @Override

    public void mouseEntered(MouseEvent me) {}



    @Override

    public void mouseExited(MouseEvent me) {}
    /*
    * God will perish by my hands
    *
    * */
    //Launches the Game

    public static void main(String[] args) throws IOException { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }







}