package org.example.Model;

import org.example.Model.itemStuff.DamageItem;
import org.example.Model.itemStuff.DefenseItem;
import org.example.Model.itemStuff.HealingItem;
import org.example.Model.itemStuff.Item;

public class Creature implements Attacker {
    private int health, damage, defense, speed;
    private String name;
    private Item[] inventory = new Item[10];
    private DamageItem weapon;
    private HealingItem ring;
    private DefenseItem armour;

    @Override
    public int attack(Creature enemy) {
        // add dice roll logic
        enemy.setHealth(enemy.getHealth() - weapon.use());
        return enemy.getHealth();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public DamageItem getWeapon() {
        return weapon;
    }

    public void setWeapon(DamageItem weapon) {
        this.weapon = weapon;
    }

    public HealingItem getRing() {
        return ring;
    }

    public void setRing(HealingItem ring) {
        this.ring = ring;
    }

    public DefenseItem getArmour() {
        return armour;
    }

    public void setArmour(DefenseItem armour) {
        this.armour = armour;
    }
}
