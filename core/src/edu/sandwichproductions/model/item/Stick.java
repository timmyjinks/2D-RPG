package edu.sandwichproductions.model.item;

import com.badlogic.gdx.graphics.g2d.Sprite;
import edu.sandwichproductions.view.ItemSprite;

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
