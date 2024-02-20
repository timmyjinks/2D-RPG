package edu.sandwichproductions.model.entity;

public class Goblin extends Enemy {
    public Goblin(String name) {
        super(name, 40, 25, 0);
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
