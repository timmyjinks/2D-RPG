package edu.sandwichproductions.model.item;

import edu.sandwichproductions.util.ItemSprite;

public class Rags extends DefenseItem{
    public Rags() {
        super("Rags", 3, 1, ItemSprite.RAGS);
        this.itemType = ITEM_TYPE.RAGS;
    }
}
