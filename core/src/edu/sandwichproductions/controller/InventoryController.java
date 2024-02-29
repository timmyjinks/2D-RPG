package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.entity.Entity;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.*;

import java.util.ArrayList;

public class InventoryController {
    public static void setItem(Item.ITEM_TYPE itemType, Entity player) {
        Item[] inventory = player.getInventory();
        for (int inventorySpot = 0; inventorySpot < inventory.length; inventorySpot++) {
            if (inventory[inventorySpot] != null) {
                if (inventory[inventorySpot].getItemType() == itemType) {
                    equipItem(itemType, player, inventory[inventorySpot]);
                    inventory[inventorySpot] = null;
                    break;
                }
            }
        }
        if (itemType == Item.ITEM_TYPE.DAMAGE_ITEM){
            equipItem(itemType, player, new Stick("Stick", 10, 4, 1, 0, "assets/room.png"));
        }
    }

    public static ArrayList<Item> getItems (Item.ITEM_TYPE itemType, Entity player){
        ArrayList<Item> items = new ArrayList<>();
        Item[] playerItems = player.getInventory();
        for (Item playerItem : playerItems) {
            if (playerItem != null){
                if (playerItem.getItemType() == itemType){
                    items.add(playerItem);
                }
            }
        }
        return items;
    }

    public static void equipItem(Item.ITEM_TYPE itemType, Entity player, Item equipItem){
        ArrayList<Item> tempArray = getItems(itemType, player);
        Item[] playerItems = new Item[tempArray.size()];
        switch (itemType){
            case DAMAGE_ITEM -> player.setWeapon((DamageItem) equipItem);
            case HEALING_ITEM -> player.setRing((HealingItem) equipItem);
            case DEFENSE_ITEM -> player.setArmour((DefenseItem) equipItem);
        }

    }

    public void moveItemsInInventory(Player player, int item1, int item2) {
        Item[] playerItems = player.getInventory();
        Item tempItem = playerItems[item1];
        playerItems[item1] = playerItems[item2];
        playerItems[item2] = tempItem;
    }
}
