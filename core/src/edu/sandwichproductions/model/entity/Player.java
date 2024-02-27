package edu.sandwichproductions.model.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Item;

import java.util.Arrays;

public abstract class Player extends Entity {
    private static AnimationHandler animatePlayer;
    private static Animation<TextureRegion> playerAnimation;
    private HealingItem ring;
    private Item[] healingPotions = new Item[10];
    private Item[] inventory = new Item[10];

    public Player(String name, int health, int speed, int armorClass){
        super(name, health, speed, armorClass);
        setPositionInRoom(24);
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item item) {

    }
    public int howManyPotions(){
        int howManyPots = 0;
        for (int howMany = 0; howMany < healingPotions.length; howMany++){
            if (healingPotions[howMany] != null){
                howManyPots++;
            } else {
                return howManyPots;
            }
        }
        return howManyPots;
    }

    @Override
    public String toString() {
        return "Player{" +
                " name= " + super.getName() +
                ", healingPotions=" + howManyPotions() +
                ", inventory=" + Arrays.toString(inventory) +
                '}';
    }
}
