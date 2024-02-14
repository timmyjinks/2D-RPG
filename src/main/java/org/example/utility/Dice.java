package org.example.utility;

import java.util.Random;

public class Dice {
    private Random myRandom = new Random();

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
            total += rollDice(sides);
        }
        total += modifier;
        return total;
    }
}
