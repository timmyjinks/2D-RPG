package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.util.ItemSprite;

public class Druid extends Player{
    public Druid(String name) {
        super(name,0,0,0);
    }


    @Override
    public void setSprite() {
        super.sprite = ItemSprite.DRUID;
    }

    @Override
    public String toString() {
        return "Druid: " + super.toString();
    }
}
