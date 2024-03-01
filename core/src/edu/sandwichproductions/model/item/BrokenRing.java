package edu.sandwichproductions.model.item;

public class BrokenRing extends HealingItem{
    public BrokenRing() {
        super("Broken Ring", 10, 4, 1, 0, "assets/room.png");
        this.itemType = ITEM_TYPE.BROKEN_RING;
    }

    @Override
    public int use() {
        return itemDice.rollDice(diceSides,diceAmount,damageModifier);
    }
}
