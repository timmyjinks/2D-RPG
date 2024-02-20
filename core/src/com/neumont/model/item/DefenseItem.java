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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (defense <= 0) {
            this.defense = 1;
        } else if (defense > 15) {
            this.defense = 15;
        } else {
            this.defense = defense;
        }
    }
}
