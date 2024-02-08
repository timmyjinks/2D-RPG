package org.example.Model.itemStuff;

public class DefenseItem extends Item {
    private final int defense;

    public DefenseItem(String name, int durability, int defense) {
        super(name, durability);
        this.defense = defense;
    }

    @Override
    public int use() {
        return this.defense;
    }
}
