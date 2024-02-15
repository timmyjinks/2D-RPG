package org.example.model;

import org.example.model.itemStuff.Item;

import java.util.Arrays;

public abstract class Player extends Entity {
    private Item healingItem, defenseItem, damageItem;
    private int healingPotions = 0;
    private Item[] inventory = new Item[10];
    private int positionInRoom;

    public Player(String name){
        super(name);
        positionInRoom = 24;
    }

    public int getPositionInRoom() {
        return positionInRoom;
    }

    public void setPositionInRoom(int positionInRoom) {
        this.positionInRoom = positionInRoom;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item item) {

    }

    @Override
    public String toString() {
        return "Player{" +
                " name= " + super.getName() +
                "healingItem=" + healingItem +
                ", defenseItem=" + defenseItem +
                ", damageItem=" + damageItem +
                ", healingPotions=" + healingPotions +
                ", inventory=" + Arrays.toString(inventory) +
                ", positionInRoom=" + positionInRoom +
                '}';
    }
}
