package edu.sandwichproductions.model.item;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Stick extends DamageItem{
    public Stick(String name, int durability, int diceSides, int diceAmount, int damageModifier, Sprite sprite) {
        super(name, durability, diceSides, diceAmount, damageModifier, sprite);
        this.itemType = ITEM_TYPE.STICK;
    }
    @Override
    public int use() {
        return itemDice.rollDice(diceSides, diceAmount, damageModifier);
    }
}
