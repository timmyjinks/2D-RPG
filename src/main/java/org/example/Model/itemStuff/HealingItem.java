package org.example.Model.itemStuff;

public class HealingItem extends  Item{
    public final int healthPower;

    public HealingItem(String name, int durability, int healthPower) {
        super(name, durability);
        this.healthPower = healthPower;
    }

    @Override
    public int use() {
        return this.healthPower;
    }
}
