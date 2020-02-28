package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TypingMinigame {
    private String match;
    private ArrayList<String> words = new ArrayList<>();
    private String userAnswer = "";
    private int count = 0;
//    private Scanner scan = new Scanner(System.in);
    public TypingMinigame(){
        words.add("kevin");
        words.add("louie");
        words.add("albin");
        int randNum = (int)(Math.random()*10);
        while (randNum>=3 && count<4){
            randNum = (int)(Math.random()*10);
            count++;
        }
        if(randNum>=3){
            randNum = 2;
        }
        match = words.get(randNum);
//        System.out.println(match);

    }
    public void getChar(char character){
        userAnswer+=character;
    }
    public String giveWord(){
        return match;
    }
    public void draw(Graphics pen){
        pen.setColor(Color.white);
        pen.drawString(match,100,100);
        pen.drawString(userAnswer,100,125);
        if(userAnswer.equalsIgnoreCase(match)){
            pen.setColor(Color.yellow);
            pen.drawString("Completed! Good job!",100,200);
        }
    }
//    public
}
