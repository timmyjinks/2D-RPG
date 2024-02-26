package edu.sandwichproductions.model.item;

import com.badlogic.gdx.graphics.g2d.Sprite;
import edu.sandwichproductions.util.Dice;

public abstract class Item {
    protected String name;
    protected int durability;
    protected Dice itemDice = new Dice();
    protected Sprite itemSprite;

    public Item(String name, int durability) {
        this.name = name;
        this.durability = durability;
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

    @Override
    public String toString() {
        return "\nName: " + this.name +
               "\nDurability: " + this.durability;
    }

}
