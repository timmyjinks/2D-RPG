package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.util.ItemSprite;

public class Monk extends Player{
    public Monk(String name){
        super(name,0,0,0);
    }

    @Override
    public void setSprite() {
        super.sprite = ItemSprite.MONK;
    }

    @Override
    public String toString() {
        return "Monk: " + super.toString();
    }
}
