package edu.sandwichproductions.model.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class DamageItem extends Item {
    protected int diceSides;
    protected int diceAmount;
    protected int damageModifier;

    public DamageItem(String name, int durability, int diceSides, int diceAmount, int damageModifier, Sprite sprite) {
        super(name, durability,sprite);
        this.diceSides = diceSides;
        this.diceAmount = diceAmount;
        this.damageModifier = damageModifier;
        super.itemType = ITEM_TYPE.DAMAGE_ITEM;
    }
    public int getDamageModifier(){
        return damageModifier;
    }

    @Override
    public int use() {
        super.setDurability(1);
        return itemDice.rollDice(diceSides, diceAmount, damageModifier);
    }
}
