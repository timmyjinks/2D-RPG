package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.util.Dice;

public abstract class Enemy extends Entity {
    public Enemy(String name, int health, int speed, int armorClass) {
        super(name, (int) (health * Dice.setMode), speed, armorClass); //TODO fix all enemies starting with 0 health
    }

    public boolean willDropItem() {
        return (int)(Math.random() * (50 + 1) + 1) == 1;
    }

    public boolean isQuestEnemy() {
        return false;
    }
}
