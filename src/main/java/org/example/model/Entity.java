package org.example.model;

import org.example.model.itemStuff.DamageItem;
import org.example.model.itemStuff.DefenseItem;
import org.example.model.itemStuff.HealingItem;

public abstract class Entity implements Attacker {
    private int health, speed;
    private String name;
    private boolean isAlive;
    private DamageItem weapon;
    private HealingItem ring;
    private DefenseItem armour;

    public Entity(String name) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        isAlive = true;
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

    public boolean isAlive() {
        return this.health > 0;
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