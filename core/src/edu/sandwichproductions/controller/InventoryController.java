package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.entity.Entity;
import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.model.item.Item;
import edu.sandwichproductions.model.item.Stick;

public class InventoryController {
    public static void setWeapon(Entity player){
        Item[] inventory = player.getInventory();
        for (int inventorySpot = 0; inventorySpot < inventory.length; inventorySpot++){
            if (inventory[inventorySpot] != null){
                if (inventory[inventorySpot].getItemType().contains(Item.ITEM_TYPE.DAMAGE_ITEM.toString())){
                    player.setWeapon((DamageItem) inventory[inventorySpot]);
                    inventory[inventorySpot] = null;
                    break;
                }
            }
        }
            player.setWeapon(new Stick("Stick", 10, 4, 1, 0));
    }
    public void setArmor(Entity player){

    }
    public void setRing(Entity player){

    }
}
