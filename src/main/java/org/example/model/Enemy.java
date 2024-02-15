package org.example.model;

public abstract class Enemy extends Entity {
    public Enemy(String name, int health, int speed) {
        super(name);
    }

    public boolean willDropItem() {
        return (int)(Math.random() * (50 + 1) + 1) == 1;
    }

    public boolean isQuestEnemy() {
        return false;
    }
}