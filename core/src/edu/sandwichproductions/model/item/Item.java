package edu.sandwichproductions.model.item;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import edu.sandwichproductions.util.Dice;

public abstract class Item {
    protected String name;
    protected int durability;
    protected Dice itemDice = new Dice();
    protected Sprite itemSprite;
    protected Item.ITEM_TYPE itemType;
    public enum ITEM_TYPE {
        DAMAGE_ITEM,
        HEALING_ITEM,
        DEFENSE_ITEM,
        STICK
    }

    public Item(String name, int durability, String filePath) {
        this.name = name;
        this.durability = durability;
        setItemSprite(filePath);
    }

    public ITEM_TYPE getItemType(){
        return itemType;
    }

    public abstract int use();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int itemDamage) {
        this.durability -= itemDamage;
    }

    public Sprite getItemSprite() {
        return this.itemSprite;
    }

    public void setItemSprite(String filePath) {
        this.itemSprite = new Sprite(new Texture(filePath), 178, 178);
    }

    @Override
    public String toString() {
        return "\nName: " + this.name +
               "\nDurability: " + this.durability;
    }

}
