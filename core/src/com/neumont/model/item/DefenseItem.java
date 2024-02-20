package com.neumont.model.item;

public class DefenseItem extends Item {
    private int defense;

    public DefenseItem(String name, int durability, int defense) {
        super(name, durability);
        this.defense = defense;
    }

    @Override
    public int use() {
        setDurability(1);
        return this.defense;
    }
}
