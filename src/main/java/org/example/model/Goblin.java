package org.example.model;

public class Goblin extends Enemy {
    public Goblin(String name) {
        super(name, 40, 25);
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
