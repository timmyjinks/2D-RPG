package edu.sandwichproductions.model.entity;

public class Skeleton extends Enemy {
    public Skeleton(String name) {
        super(name, 40, 25, 10);
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
