package edu.sandwichproductions.model.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import edu.sandwichproductions.controller.AnimationHandler;

public class Skeleton extends Enemy {
    private static Animation<TextureRegion> skeletonAnimation = AnimationHandler.animate("Skeleton_Idle.png",4,1,4,.2f);
    public Skeleton(String name) {
        super(name, 40, 25, 0);
    }

    public static Animation<TextureRegion> getSkeletonAnimation(){
        return skeletonAnimation;
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
