package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Rogue extends Player{
    public Rogue(String name){
        super(name,0,0,0, ItemSprite.ROUGE);
    }
    @Override
    public String toString() {
        return "Rogue: " + super.toString();
    }
}
