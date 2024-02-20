package edu.sandwichproductions.util;

import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.model.item.DefenseItem;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Item;

import java.util.Random;

public class ItemGenerator {
    private Random randomItem = new Random();

    public Item generateItem() {
        int itemType = randomItem.nextInt(3) + 1;
        int whichItem = randomItem.nextInt(1000) + 1;
        // 90% chance for common 9% chance for uncommon 0.9% chance for rare 0.1% chance for epic
        if (whichItem <= 900) {
            return commonItem(itemType);
        } else if (whichItem <= 990) {
            return uncommonItem(itemType);
        } else if (whichItem <= 999) {
            return rareItem(itemType);
        } else {
            return epicItem(itemType);
        }
    }

    public Item generateBossItem() {
        int itemType = randomItem.nextInt(3) + 1;
        int itemRarity = randomItem.nextInt(100) + 1;
        // 90% chance for epic 10% chance for legendary
        if (itemRarity <= 90) {
            return epicItem(itemType);
        } else {
            return legendaryItem(itemType);
        }
    }

    public Item commonItem(int itemType) {
        return switch (itemType) {
            case 1 -> new DamageItem("Broken Sword", 15, 6, 1, 1);
            case 2 -> new HealingItem("Broken Ring", 9, 4, 2, 2);
            case 3 -> new DefenseItem("Rags", 15, 1);
            default -> throw new IllegalStateException("Unexpected value: " + itemType);
        };
    }

    public Item uncommonItem(int itemType) {
        return switch (itemType) {
            case 1 -> new DamageItem("Plain ol' Sword", 20, 8, 1, 2);
            case 2 -> new HealingItem("Ring of Lesser Restoration", 12, 6, 2, 2);
            case 3 -> new DefenseItem("Leather Armor", 25, 2);
            default -> throw new IllegalStateException("Unexpected value: " + itemType);
        };
    }

    public Item rareItem(int itemType) {
        return switch (itemType) {
            case 1 -> new DamageItem("Sharp Sword", 25, 8, 2, 3);
            case 2 -> new HealingItem("Ring of Restoration", 12, 4, 4, 4);
            case 3 -> new DefenseItem("Chain-mail", 35, 3);
            default -> throw new IllegalStateException("Unexpected value: " + itemType);
        };
    }

    public Item epicItem(int itemType) {
        return switch (itemType) {
            case 1 -> new DamageItem("Fiend Slasher", 30, 4, 5, 4);
            case 2 -> new HealingItem("Ring of Greater Restoration", 15, 4, 6, 6);
            case 3 -> new DefenseItem("Enchanted Armor", 80, 3);
            default -> throw new IllegalStateException("Unexpected value: " + itemType);
        };
    }

    public Item legendaryItem(int itemType) {
        return switch (itemType) {
            case 1 -> new DamageItem("Sky Render", 35, 12, 3, 6);
            case 2 -> new HealingItem("Hero's Ring of Immortality", 18, 8, 3, 8);
            case 3 -> new DefenseItem("Ancient Dragon's Scale-mail", 100, 5);
            default -> throw new IllegalStateException("Unexpected value: " + itemType);
        };
    }
}