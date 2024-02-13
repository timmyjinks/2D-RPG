package org.example.Model;

import org.example.Model.itemStuff.Item;

public class Player extends ABSCreature{
    private Item healingItem, defenseItem, damageItem;
    private int healingPotions = 0;
    private int positionInRoom;
    public Player(){
        positionInRoom = 24;
    }

    public int getPositionInRoom() {
        return positionInRoom;
    }

    public void setPositionInRoom(int positionInRoom) {
        this.positionInRoom = positionInRoom;
    }
}
