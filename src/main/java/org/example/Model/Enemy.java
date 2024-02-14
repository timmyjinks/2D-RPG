package org.example.Model;

public abstract class Enemy extends Creature {
    public boolean willDropItem() {
        return (int)(Math.random() * (50 + 1) + 1) == 1;
    }

    public boolean isQuestEnemy() {
        return false;
    }
}
