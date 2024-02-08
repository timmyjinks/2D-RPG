package org.example.Model.itemStuff;

public class DamageItem extends Item {
    private final int minDamage;
    private final int maxDamage;

    public DamageItem(String name, int durability, int minDamage, int maxDamage) {
        super(name, durability);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public int use() {
        return (int)Math.floor(Math.random() * (maxDamage - minDamage + 1) + minDamage);
    }
}
