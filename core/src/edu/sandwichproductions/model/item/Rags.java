package edu.sandwichproductions.model.item;

public class Rags extends DefenseItem{
    public Rags() {
        super("Rags", 10, 0, "assets/room.png");
        this.itemType = ITEM_TYPE.RAGS;
    }

    @Override
    public int use() {
        return getDefense();
    }
}
