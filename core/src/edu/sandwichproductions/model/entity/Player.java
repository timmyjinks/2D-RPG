package edu.sandwichproductions.model.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.model.item.Item;
import edu.sandwichproductions.model.item.Stick;
import edu.sandwichproductions.view.ItemSprite;

public abstract class Player extends Entity {
    private static AnimationHandler animatePlayer;
    private static Animation<TextureRegion> playerAnimation;
    private Item[] healingPotions = new Item[10];

    public Player(String name, int health, int speed, int armorClass){
        super(name, health, speed, armorClass);
        setPositionInRoom(24);
    }

    public void addItem(Item addedItem){
        for (int inventoryPosition = 0; inventoryPosition < this.inventory.length; inventoryPosition++){
            if (this.getWeapon() == null){
                this.setWeapon(new Stick());
                break;
            }
            if (this.inventory[inventoryPosition] == null){
                this.inventory[inventoryPosition] = addedItem;
                if (this.getWeapon().getItemType() == Item.ITEM_TYPE.STICK && addedItem.getItemType() == Item.ITEM_TYPE.DAMAGE_ITEM){
                    this.setWeapon((DamageItem) addedItem);
                    this.inventory[inventoryPosition] = null;
                }
                break;
            }
        }
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
                '}';
    }
}
