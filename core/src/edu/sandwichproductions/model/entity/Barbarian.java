package edu.sandwichproductions.model.entity;

public class Barbarian extends Player {
    public Barbarian(String name) {
        super(name, 65, 20, 0);
    }

    @Override
    public String toString() {
        return "Barbarian:" + super.toString();
    }
}
