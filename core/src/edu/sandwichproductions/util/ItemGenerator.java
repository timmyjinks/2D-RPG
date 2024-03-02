package edu.sandwichproductions.util;

import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.model.item.DefenseItem;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Item;
import edu.sandwichproductions.model.item.*;

import java.util.Random;

public class ItemGenerator {
    public static Item generateItem() {
        Random randomItem = new Random();
        int itemType = randomItem.nextInt(100) + 1;
        int whichItem = randomItem.nextInt(1000) + 1;
        // 80% chance for common 19% chance for uncommon 0.9% chance for rare 0.1% chance for epic
        if (whichItem <= 800) {
            return commonItem(itemType);
        } else if (whichItem <= 990) {
            return uncommonItem(itemType);
        } else if (whichItem <= 999) {
            return rareItem(itemType);
        } else {
            return epicItem(itemType);
        }
    }

    public static Item generateBossItem() {
        Random randomItem = new Random();
        int itemType = randomItem.nextInt(100) + 1;
        int itemRarity = randomItem.nextInt(100) + 1;
        // 90% chance for epic 10% chance for legendary
        if (itemRarity <= 90) {
            return epicItem(itemType);
        } else {
            return legendaryItem(itemType);
        }
    }

    public static Item commonItem(int itemType) {
        if (itemType < 33) {
            return new Stick(3);
        } else if (itemType < 67) {
            return new BrokenRing();
        } else {
            return new Rags();
        }
    }

    public static Item uncommonItem(int itemType) {
        if (itemType < 33) {
            return new DamageItem("Plain ol' Sword", 20, 8, 1, 2, ItemSprite.ROOM);
        } else if (itemType < 67) {
            return new HealingItem("Ring of Lesser Restoration", 12, 6, 2, 2, ItemSprite.ROOM);
        } else {
            return new DefenseItem("Leather Armor", 25, 2, ItemSprite.ROOM);
        }
    }

    public static Item rareItem(int itemType) {
        if (itemType < 33) {
            return new DamageItem("Sharp Sword", 25, 8, 2, 3, ItemSprite.ROOM);
        } else if (itemType < 67) {
            return new HealingItem("Ring of Restoration", 12, 4, 4, 4, ItemSprite.ROOM);
        } else {
            return new DefenseItem("Chain-mail", 35, 3, ItemSprite.ROOM);
        }
    }

    public static Item epicItem(int itemType) {
        if (itemType < 33) {
            return new DamageItem("Fiend Slasher", 30, 4, 5, 4, ItemSprite.ROOM);
        } else if (itemType < 67) {
            return new HealingItem("Ring of Greater Restoration", 15, 4, 6, 6, ItemSprite.RING);
        } else {
            return new DefenseItem("Enchanted Armor", 80, 3, ItemSprite.ROOM);
        }
    }

    public static Item legendaryItem(int itemType) {
        if (itemType < 33) {
            return new DamageItem("Sky Render", 35, 12, 3, 6, ItemSprite.SKY_RENDER);
        } else if (itemType < 67) {
            return new HealingItem("Hero's Ring of Immortality", 18, 8, 3, 8, ItemSprite.ROOM);
        } else {
            return new DefenseItem("Ancient Dragon's Scale-mail", 100, 5, ItemSprite.ROOM);
        }
    }
}