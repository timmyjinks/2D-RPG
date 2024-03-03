package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.util.ItemSprite;

public class Bard extends Player{
    public Bard(String name){
        super(name,0,0,0);
    }

    @Override
    public void setSprite() {
        super.sprite = ItemSprite.BARD;
    }

    @Override
    public String toString() {
        return "Bard: " + super.toString();
    }
}