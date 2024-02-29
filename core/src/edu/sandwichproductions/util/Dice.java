package edu.sandwichproductions.util;

import java.util.Random;

public class Dice {
    private Random myRandom = new Random();
    public static double setMode = 1;

    public int rollDice(int sides) {
        return myRandom.nextInt(1, sides + 1);
    }
//
//    public int rollDice(int sides, int min, int max) {
//        int randomRollCount = myRandom.nextInt(min, max + 1);
//        return rollDice(sides, randomRollCount);
//    }

    public int rollDice(int sides, int count, int modifier) {
        // loop n times
        int total = 0;
        for (int n = 0; n < count; n++) {
            total += rollDice((int) (sides * setMode));
        }
        total += modifier;
        return total;
    }
    public void setMode(double mode){
        if(setMode < 1){
            setMode = 1;
        }
        else {
            setMode = setMode * mode;
        }
    }

}
