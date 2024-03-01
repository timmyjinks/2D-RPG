package edu.sandwichproductions.model.item;

import edu.sandwichproductions.util.ItemSprite;

public class Stick extends DamageItem{
    public Stick() {
        super("Stick", 10, 4, 1, 0, ItemSprite.STICK);
        this.itemType = ITEM_TYPE.STICK;
    }
    @Override
    public int use() {
        return itemDice.rollDice(diceSides, diceAmount, damageModifier);
    }
}
