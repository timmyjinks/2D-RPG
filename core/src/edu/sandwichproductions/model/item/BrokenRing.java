package edu.sandwichproductions.model.item;

import edu.sandwichproductions.util.ItemSprite;

public class BrokenRing extends HealingItem{
    public BrokenRing() {
        super("Broken Ring", 10, 4, 1, 0, ItemSprite.ROOM);
        this.itemType = ITEM_TYPE.BROKEN_RING;
    }

    @Override
    public int use() {
        return itemDice.rollDice(diceSides,diceAmount,damageModifier);
    }
}
