package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Monk extends Player{
    public Monk(String name){
        super(name,0,0,0, ItemSprite.MONK);
    }
    @Override
    public String toString() {
        return "Monk: " + super.toString();
    }
}
