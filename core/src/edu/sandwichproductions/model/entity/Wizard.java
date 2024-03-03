package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Wizard extends Player{
    public Wizard(String name) {
        super(name, 30, 25, 10, ItemSprite.WIZARD);
    }
}
