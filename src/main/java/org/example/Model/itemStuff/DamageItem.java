package org.example.Model.itemStuff;

public class DamageItem extends Item {
    protected int minDamage;
    protected int maxDamage;

    public DamageItem(String name, int durability, int minDamage, int maxDamage) {
        super(name, durability);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);
    }

    @Override
    public int use() {
        super.setDurability(1);
        return (int)Math.floor(Math.random() * (maxDamage - minDamage + 1) + minDamage);
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public void setMinDamage(int minDamage) {
        if (minDamage <= 0) {
            this.minDamage = 1;
        } else if (minDamage > 30) {
            this.minDamage = 30;
        } else {
            this.minDamage = minDamage;
        }
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        if (maxDamage <= 0) {
            this.maxDamage = 1;
        } else if (maxDamage > 30) {
            this.maxDamage = 30;
        } else {
            this.maxDamage = maxDamage;
        }
    }
}
