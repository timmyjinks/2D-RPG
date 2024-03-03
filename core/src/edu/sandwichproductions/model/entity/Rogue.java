package edu.sandwichproductions.model.entity;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.util.ItemSprite;

public class Rogue extends Player{
    public Rogue(String name){
        super(name,0,0,0);
    }

    @Override
    public void setSprite() {
        super.sprite = ItemSprite.ROUGE;
    }

    @Override
    public String toString() {
        return "Rogue: " + super.toString();
    }
}
