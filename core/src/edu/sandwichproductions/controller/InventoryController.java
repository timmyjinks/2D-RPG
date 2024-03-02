package edu.sandwichproductions.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import edu.sandwichproductions.model.entity.Entity;
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

    public static void checkEquippedItems(Entity player){
        DamageItem tempWep = player.getWeapon();
        HealingItem tempHeal = player.getRing();
        DefenseItem tempDef = player.getArmour();
        if (tempWep == null){
            setItem(Item.ITEM_TYPE.DAMAGE_ITEM, player);
        }
        if (tempHeal == null){
            setItem(Item.ITEM_TYPE.HEALING_ITEM, player);
        }
        if (tempDef == null){
            setItem(Item.ITEM_TYPE.DEFENSE_ITEM, player);
        }
        if (tempWep != null && tempWep.getItemType() == Item.ITEM_TYPE.STICK){
            setItem(Item.ITEM_TYPE.DAMAGE_ITEM, player);
        }
        if (tempHeal != null && tempHeal.getItemType() == Item.ITEM_TYPE.BROKEN_RING){
            setItem(Item.ITEM_TYPE.HEALING_ITEM,player);
        }
        if (tempDef != null && tempDef.getItemType() == Item.ITEM_TYPE.RAGS){
            setItem(Item.ITEM_TYPE.DEFENSE_ITEM, player);
        }
    }

    public static void equipItem(Item.ITEM_TYPE itemType, Entity player, Item equipItem){
        switch (itemType){
            case DAMAGE_ITEM, STICK -> player.setWeapon((DamageItem) equipItem);
            case HEALING_ITEM, BROKEN_RING -> player.setRing((HealingItem) equipItem);
            case DEFENSE_ITEM, RAGS -> player.setArmour((DefenseItem) equipItem);
        }
    }


    public static boolean isPressingI() {
        if (Gdx.input.isButtonJustPressed(Input.Keys.I)) {
            return true;
        }
        return false;
    }
}
