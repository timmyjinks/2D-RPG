package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.util.Dice;

import java.util.Random;

public abstract class Enemy extends Entity {
    public Enemy(String name, int health, int speed, int armorClass) {
        super(name, (int) (health * Dice.setMode), speed, armorClass); //TODO fix all enemies starting with 0 health
    }

    public boolean willDropItem() {
        Random dropChance = new Random();
        return (dropChance.nextInt(100)+1 <= 100);
    }

    public boolean isQuestEnemy() {
        return false;
    }
}
