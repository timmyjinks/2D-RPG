package edu.sandwichproductions.model.entity;


import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.model.item.DefenseItem;
import edu.sandwichproductions.util.Dice;

public abstract class Entity implements Attacker {
    private int health, speed, armorClass;
    private String name;
    private boolean isAlive;
    private DamageItem weapon;
    private DefenseItem armour;
    private Dice entityDice = new Dice();
    private int positionInRoom;

    public Entity(String name, int health, int speed, int armorClass) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.armorClass = armorClass;
        isAlive = true;
        this.weapon = new DamageItem("stick", 10, 4, 2, 1);
    }

    @Override
    public int attack(Entity attacked) {
        int hit = entityDice.rollDice(20, 1, weapon.getDamageModifier());
        int damage = 0;
        if (attacked.getArmour() != null) {
            if (hit >= attacked.getArmorClass() + attacked.getArmour().use()) {
                damage += weapon.use();
                if (hit == 20) {
                    damage *= 2;
                }
            }
        }
        damage += weapon.use();
        if (hit == 20) {
            damage *= 2;
        }
        attacked.setHealth(attacked.getHealth() - damage);
        return attacked.getHealth();
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            health = 0;
            isAlive = false;
        }
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


    public DefenseItem getArmour() {
        return armour;
    }

    public void setArmour(DefenseItem armour) {
        this.armour = armour;
    }

    public int getPositionInRoom() {
        return this.positionInRoom;
    }

    public void setPositionInRoom(int positionInRoom) {
        this.positionInRoom = positionInRoom;
    }
}