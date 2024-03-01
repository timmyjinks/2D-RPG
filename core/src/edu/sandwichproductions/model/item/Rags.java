package edu.sandwichproductions.model.item;

import edu.sandwichproductions.view.ItemSprite;

public class Rags extends DefenseItem{
    public Rags() {
        super("Rags", 10, 0, ItemSprite.STICK);
        this.itemType = ITEM_TYPE.RAGS;
    }

    @Override
    public int use() {
        return getDefense();
    }
}
