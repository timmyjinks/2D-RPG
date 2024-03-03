package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Druid extends Player{
    public Druid(String name){
        super(name,0,0,0, ItemSprite.DRUID);
    }
    @Override
    public String toString() {
        return "Druid: " + super.toString();
    }
}
