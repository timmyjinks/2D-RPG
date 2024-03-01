package edu.sandwichproductions.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import edu.sandwichproductions.model.entity.Entity;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.*;

import java.util.ArrayList;

public class InventoryController {
    public static void setItem(Item.ITEM_TYPE itemType, Entity player) {
        Item[] inventory = player.getInventory();
        for (Item item : inventory) {
            if (item != null) {
                if (item.getItemType() == itemType) {
                    equipItem(itemType, player, item);
                    break;
                }
            }
        }
        equipDefaults(itemType, player);
    }

    private static void equipDefaults(Item.ITEM_TYPE itemType, Entity player){
        switch (itemType){
            case DAMAGE_ITEM -> equipItem(itemType, player, new Stick());
            case DEFENSE_ITEM -> equipItem(itemType, player, new Rags());
            case HEALING_ITEM -> equipItem(itemType, player, new BrokenRing());
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
        switch (itemType){
            case DAMAGE_ITEM, STICK -> player.setWeapon((DamageItem) equipItem);
            case HEALING_ITEM, BROKEN_RING -> player.setRing((HealingItem) equipItem);
            case DEFENSE_ITEM, RAGS -> player.setArmour((DefenseItem) equipItem);
        }
    }

    public static void equipItem(Item.ITEM_TYPE itemType, Entity player, Item equipItem, int inventorySpot){
        if (inventorySpot != 0){
            player.setItem(itemType, equipItem, inventorySpot);
        } else {
            equipItem(itemType, player, equipItem);
        }
    }

    public void moveItemsInInventory(Player player, int item1, int item2) {
        // no work sadge D:
        Item[] playerItems = player.getInventory();
        Item tempItem = playerItems[item1];
        playerItems[item1] = playerItems[item2];
        playerItems[item2] = tempItem;
    }

    public static boolean isPressingI() {
        if (Gdx.input.isButtonJustPressed(Input.Keys.I)) {
            return true;
        }
        return false;
    }
}
