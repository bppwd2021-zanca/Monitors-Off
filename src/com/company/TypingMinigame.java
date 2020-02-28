package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TypingMinigame {
    private String match;
    private ArrayList<String> words = new ArrayList<>();
    private Random random;
    private int count = 0;
    private Scanner scan = new Scanner(System.in);
    public TypingMinigame(){
        words.add("Kevin");
        words.add("Louie");
        words.add("Albin");
        int randNum = (int)(Math.random()*10);
        while (randNum>=3 && count<4){
            randNum = (int)(Math.random()*10);
            count++;
        }
        if(randNum>=3){
            randNum = 2;
        }
        match = words.get(randNum);
        System.out.println(match);

    }
//    public
}
