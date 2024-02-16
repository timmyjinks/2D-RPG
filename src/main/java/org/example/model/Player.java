package org.example.model;

import org.example.model.itemStuff.Item;

import java.util.Arrays;

public abstract class Player extends Entity {
    private int healingPotions = 0;
    private Item[] inventory = new Item[10];
    private int positionInRoom;

    public Player(String name, int health, int speed){
        super(name, health, speed);
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
}
