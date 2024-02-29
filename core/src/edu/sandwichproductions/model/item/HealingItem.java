package edu.sandwichproductions.model.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class HealingItem extends  Item{
    protected int diceSides;
    protected int diceAmount;
    protected int damageModifier;

    public HealingItem(String name, int durability, int diceSides, int diceAmount, int damageModifier, String filePath) {
        super(name, durability, filePath);
        this.diceSides = diceSides;
        this.diceAmount = diceAmount;
        this.damageModifier = damageModifier;
        super.itemType = ITEM_TYPE.HEALING_ITEM;
    }

    @Override
    public int use() {
        super.setDurability(1);
        return itemDice.rollDice(diceSides, diceAmount, damageModifier);
    }
}
