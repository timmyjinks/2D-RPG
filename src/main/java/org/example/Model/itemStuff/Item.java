package org.example.Model.itemStuff;

public abstract class Item {
    protected String name;
    protected int durability;

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
