package edu.sandwichproductions.model.item;

public class Stick extends DamageItem{
    public Stick(String name, int durability, int diceSides, int diceAmount, int damageModifier, String filePath) {
        super(name, durability, diceSides, diceAmount, damageModifier, filePath);
        this.itemType = ITEM_TYPE.STICK;
    }
    @Override
    public int use() {
        return itemDice.rollDice(diceSides, diceAmount, damageModifier);
    }
}
