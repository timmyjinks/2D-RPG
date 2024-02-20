package edu.sandwichproductions.model.item;

public class HealingItem extends  Item{
    protected int diceSides;
    protected int diceAmount;
    protected int damageModifier;

    public HealingItem(String name, int durability, int diceSides, int diceAmount, int damageModifier) {
        super(name, durability);
        this.diceSides = diceSides;
        this.diceAmount = diceAmount;
        this.damageModifier = damageModifier;
    }

    @Override
    public int use() {
        super.setDurability(1);
        return itemDice.rollDice(diceSides, diceAmount, damageModifier);
    }
}
