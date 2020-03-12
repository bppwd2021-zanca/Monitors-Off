package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TypingMinigame {
    private String match;
    private ArrayList<String> words = new ArrayList<>();
    private String userAnswer = "";
    private int count = 0;
    private int victoryCooldown,failureCooldown;
    private boolean failed;
    private double progress=100;
    private boolean matching = false;
    private int numOfWords;
    private String filePath = "textFiles/words.txt";
    private BufferedReader reader;
    public TypingMinigame() throws IOException {
        try {
            reader=new BufferedReader(new FileReader(new File(filePath)));
            String line;
            while((line=reader.readLine())!=null){
                words.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        numOfWords = words.size();
        reset();
        failed=false;
        victoryCooldown=0;
        failureCooldown=0;
//        System.out.println(match);

    }
    public void getChar(char character){
        userAnswer+=character;
    }
    public String giveWord(){
        return match;
    }
    public void reset(){
        int randNum = (int)(Math.random()*numOfWords);
        match = words.get(randNum);
        userAnswer = "";
        progress=100;
        failed=false;
    }
    public void backspace(){
        if(userAnswer.length()>0)
            userAnswer=userAnswer.substring(0,userAnswer.length()-1);
    }
    public void draw(Graphics2D pen){
        if(victoryCooldown>0 && victoryCooldown<=100){
            victoryCooldown++;
            pen.setColor(Color.green);
            pen.drawString("Completed! Good job!",60,150);
        }if(victoryCooldown>1000)
            victoryCooldown=0;
        if(progress>0)
            progress-=.5;
        else{
            failed=true;
            failureCooldown=1;
            victoryCooldown=0;
        }if(matching){
            reset();
            matching = false;
        }if(failureCooldown>0 && failureCooldown<=100){
            failureCooldown++;
            pen.setColor(Color.red);
            pen.drawString("You failed to type a simple word!",40,150);
        }
        pen.setColor(Color.white);
        pen.drawString(match,100,100);
        pen.setColor(Color.red);
        pen.fillRect(70,70,100,5);
        pen.setColor(Color.green);
        pen.fillRect(70,70,(int)((progress/100)*100),5);
        pen.setColor(Color.yellow);
        pen.drawString(userAnswer,100,125);
        if(userAnswer.equalsIgnoreCase(match)){
            pen.setColor(Color.green);
            victoryCooldown=1;
            failureCooldown=0;
            matching = true;
        }
    }public boolean hasFailed(){
        return failed;
    }
}
