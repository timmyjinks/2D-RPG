package com.neumont.model.entity;

public abstract class Enemy extends Entity {
    public Enemy(String name, int health, int speed) {
        super(name, health, speed);
    }

    public boolean willDropItem() {
        return (int)(Math.random() * (50 + 1) + 1) == 1;
    }

    public boolean isQuestEnemy() {
        return false;
    }
}
