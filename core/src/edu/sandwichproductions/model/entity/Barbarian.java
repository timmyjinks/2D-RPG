package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Barbarian extends Player {
    public Barbarian(String name) {
        super(name, 65, 20, 10);
    }

    @Override
    public void setSprite() {
        super.sprite = ItemSprite.BARBARIAN;
    }

    @Override
    public String toString() {
        return "Barbarian:" + super.toString();
    }
}
