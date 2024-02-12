package org.example.Model.itemStuff;

public class HealingItem extends  Item{
    public int healthPower;

    public HealingItem(String name, int durability, int healthPower) {
        super(name, healthPower);
        this.healthPower = healthPower;
    }

    @Override
    public int use() {
        setDurability(1);
        return getHealthPower();
    }

    public int getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(int healthPower) {
        if (healthPower <= 0) {
            this.healthPower = 1;
        } else if (healthPower > 10) {
            this.healthPower = 10;
        } else {
            this.healthPower = healthPower;
        }
    }
}
