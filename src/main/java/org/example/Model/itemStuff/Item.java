package org.example.Model.itemStuff;

import org.example.utility.Dice;

public abstract class Item {
    protected String name;
    protected int durability;
    protected Dice itemDice = new Dice();

    public Item(String name, int durability) {
        this.name = name;
        this.durability = durability;
    }

    public abstract int use();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int itemDamage) {
        this.durability -= itemDamage;
    }
}
