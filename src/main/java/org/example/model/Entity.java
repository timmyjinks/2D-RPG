package org.example.model;

import org.example.model.itemStuff.*;

public abstract class Entity implements Attacker {
    private String name;
    private int health, speed;
    private boolean isAlive;
    private DamageItem weapon;
    private HealingItem healingItem;
    private DefenseItem armour;

    public Entity(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.isAlive = true;
        this.weapon = new Sword("Copper sword");

    }

    @Override
    public int attack(Entity enemy) {
        // add dice roll logic
        enemy.setHealth(enemy.getHealth() - weapon.use());
        return enemy.getHealth();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
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

    public boolean isAlive() {
        return this.health > 0;
    }

    public DamageItem getWeapon() {
        return weapon;
    }

    public void setWeapon(DamageItem weapon) {
        this.weapon = weapon;
    }

    public HealingItem getHealingItem() {
        return healingItem;
    }

    public void setHealingItem(HealingItem healingItem) {
        this.healingItem = healingItem;
    }

    public DefenseItem getArmour() {
        return armour;
    }

    public void setArmour(DefenseItem armour) {
        this.armour = armour;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name +
               "\nHealth: " + this.health +
               "\nSpeed: " + this.speed +
               "\nWeapon: " + this.weapon;
    }
}
