package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Bard extends Player{
    public Bard(String name){
        super(name,0,0,0, ItemSprite.BARD);
    }

    @Override
    public String toString() {
        return "Bard: " + super.toString();
    }
}