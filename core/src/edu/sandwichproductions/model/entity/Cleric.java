package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Cleric extends Player{
    public Cleric(String name){
        super(name,0,0,0, ItemSprite.CLERIC);
    }
    @Override
    public String toString() {
        return "Cleric: " + super.toString();
    }
}
