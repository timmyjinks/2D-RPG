package edu.sandwichproductions.model.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import edu.sandwichproductions.controller.AnimationHandler;

public class Skeleton extends Enemy {
    public Skeleton(String name) {
        super(name, 40, 25, 0);
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
