package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.model.item.Stick;

public class Skeleton extends Enemy {
    public Skeleton(String name) {
        super(name, entityRandom.nextInt(12, 16), entityRandom.nextInt(8,11), 12);
        this.setWeapon(new Stick());
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
