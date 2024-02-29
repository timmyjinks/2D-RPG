package edu.sandwichproductions.model.entity;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.controller.InventoryController;
import edu.sandwichproductions.model.item.*;
import edu.sandwichproductions.util.Dice;

public abstract class Entity implements Attacker {
    private int health, speed, armorClass;
    private String name;
    private boolean isAlive;
    private DamageItem weapon;
    private DefenseItem armour;
    private HealingItem ring;
    private Dice entityDice = new Dice();
    private int positionInRoom;
    protected Item[] inventory = new Item[10];

    public Entity(String name, int health, int speed, int armorClass) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.armorClass = armorClass;
        isAlive = true;
    }

    @Override
    public int attack(Entity attacked) {
        if (weapon == null){
            InventoryController.setItem(Item.ITEM_TYPE.DAMAGE_ITEM,this);
        }
        int hit = entityDice.rollDice(20, 1, weapon.getDamageModifier());
        int damage = 0;
        if (attacked.getArmour() != null) {
            if (hit >= attacked.getArmorClass() + attacked.getArmour().use()) {
                damage += weapon.use();
                if (hit == 20) {
                    damage *= 2;
                }
            }
        } else if (hit >= attacked.getArmorClass()) {
            damage += weapon.use();
            if (hit - weapon.getDamageModifier() == 20) {
                damage *= 2;
            }
        }
        if (weapon.getDurability() == 0){
            weapon = null;
        }
        attacked.setHealth(attacked.getHealth() - damage);
        return attacked.getHealth();
    }

    public Item getItem(Item.ITEM_TYPE itemType){
        return switch (itemType){
            case DAMAGE_ITEM -> this.weapon;
            case HEALING_ITEM -> this.ring;
            case DEFENSE_ITEM -> this.armour;
            default -> throw new IllegalStateException("unexpected value:" + itemType);
        };
    }
    public void setItem(Item.ITEM_TYPE itemType, Item item, int inventorySpot){
        Item tempItem = switch (itemType){
            case DAMAGE_ITEM, STICK -> setWeapon((DamageItem) item);
            case HEALING_ITEM -> setRing((HealingItem) item);
            case DEFENSE_ITEM -> setArmour((DefenseItem) item);
        };
        inventory[inventorySpot] = tempItem;
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

    public DamageItem setWeapon(DamageItem weapon) {
        DamageItem tempItem = this.weapon;
        this.weapon = weapon;
        return tempItem;
    }

    public HealingItem getRing() {
        return ring;
    }

    public HealingItem setRing(HealingItem ring) {
        HealingItem tempItem = this.ring;
        this.ring = ring;
        return tempItem;
    }

    public DefenseItem getArmour() {
        return armour;
    }

    public DefenseItem setArmour(DefenseItem armour) {
        DefenseItem tempItem = this.armour;
        this.armour = armour;
        return tempItem;
    }

    public int getPositionInRoom() {
        return this.positionInRoom;
    }

    public void setPositionInRoom(int positionInRoom) {
        this.positionInRoom = positionInRoom;
    }
    public Item[] getInventory(){
        return inventory;
    }
}