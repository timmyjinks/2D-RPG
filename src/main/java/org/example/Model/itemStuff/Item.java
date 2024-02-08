package org.example.Model.itemStuff;

public abstract class Item {
    protected String name;
    protected int durability;

    public Item(String name, int durability) {
        this.name = name;
        this.durability = durability;
    }

    public abstract int use();
}
