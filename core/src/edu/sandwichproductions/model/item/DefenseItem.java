package edu.sandwichproductions.model.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class DefenseItem extends Item {
    private int defense;

    public DefenseItem(String name, int durability, int defense, Sprite sprite) {
        super(name, durability, sprite);
        this.defense = defense;
        super.itemType = ITEM_TYPE.DEFENSE_ITEM;
    }

    @Override
    public int use() {
        setDurability(1);
        return this.defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
