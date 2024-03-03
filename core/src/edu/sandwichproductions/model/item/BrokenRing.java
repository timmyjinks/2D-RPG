package edu.sandwichproductions.model.item;

import edu.sandwichproductions.util.ItemSprite;

public class BrokenRing extends HealingItem{
    public BrokenRing() {
        super("Broken Ring", 3, 4, 1, 0, ItemSprite.BROKEN_RING);
        this.itemType = ITEM_TYPE.BROKEN_RING;
    }
}
