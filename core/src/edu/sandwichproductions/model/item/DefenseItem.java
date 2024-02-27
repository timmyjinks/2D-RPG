package edu.sandwichproductions.model.item;

public class DefenseItem extends Item {
    private int defense;

    public DefenseItem(String name, int durability, int defense) {
        super(name, durability);
        this.defense = defense;
        super.itemType = ITEM_TYPE.DEFENSE_ITEM.toString();
    }

    @Override
    public int use() {
        setDurability(1);
        return this.defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
