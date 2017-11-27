package game_lab_exam;

import  java.lang.reflect.*;
import java.util.*;

import java.util.Random;

public class CardGame {

    private  int cardvalue ;
    private  int[] cardUsed = new int[10];
    private Random randomCard;
    public  CardGame(){

        randomCard =new Random();
        cardvalue = getRandom();

    }

    private int getRandom(){
        return  randomCard.nextInt(11);
    }
    public int getCardvalue(){
        return cardvalue;
    }

}