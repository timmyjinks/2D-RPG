package edu.sandwichproductions.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import edu.sandwichproductions.controller.AnimationHandler;

public class ItemSprite {
    public static Sprite ROOM;
    public static Sprite ENEMY_R00M;
    public static Sprite BOSS_ROOM;
    public static Sprite PLACEHOLDER;
    public static Sprite CHARACTER_ITEM_SLOT;
    public static Sprite INVENTORY_ITEM_SLOT;
    public static Sprite MENU_BODY;
    public static Sprite MENU_SCREEN;
    public static Sprite STICK;
    public static Sprite SKY_RENDER;
    public static Sprite BROKEN_RING;
    public static Sprite RAGS;
    public static Sprite WOODEN_SWORD;
    public static Sprite RING_OF_LESSER_RESTORATION;
    public static Sprite LEATHER_ARMOR;
    public static Sprite SHARP_SWORD;
    public static Sprite RING_OF_RESTORATION;
    public static Sprite CHAIN_MAIL;
    public static Sprite FIEND_SLASHER;
    public static Sprite RING_OF_GREATER_RESTORATION;
    public static Sprite ENCHANTED_ARMOR;
    public static Sprite HEROES_RING_OF_IMMORTALITY;
    public static Sprite ANCIENT_DRAGON_SCALE_MAIL;


    public static AnimationHandler KNIGHT;
    public static AnimationHandler BARBARIAN;
    public static AnimationHandler BARD;
    public static AnimationHandler CLERIC;
    public static AnimationHandler DRUID;
    public static AnimationHandler MONK;
    public static AnimationHandler PALADIN;
    public static AnimationHandler ROUGE;
    public static AnimationHandler WIZARD;
    public static AnimationHandler SKELETON;

    public static void refresh() {
        ROOM = new Sprite(new Texture("room.png"), 199, 199);
        ENEMY_R00M = new Sprite(new Texture("enemyroom.png"), 199,199);
        BOSS_ROOM = new Sprite(new Texture("bossroom.png"), 199, 199);
        MENU_BODY = new Sprite(new Texture("Character_Screen_Background.png"), 1160, 1400);
        MENU_SCREEN = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 1060, 570);
        CHARACTER_ITEM_SLOT = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 250, 250);
        INVENTORY_ITEM_SLOT = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 208, 208);
        PLACEHOLDER = new Sprite(new Texture("assets/placeholder.png"), 220, 220);
        STICK = new Sprite(new Texture("Stick.png"), 220, 220);
        SKY_RENDER = new Sprite(new Texture("Sky_Render.png"), 220, 220);
        BROKEN_RING = new Sprite(new Texture("Broken_Ring.png"), 220, 220);
        RAGS = new Sprite(new Texture("Rags.png"), 183, 219);
        WOODEN_SWORD = new Sprite(new Texture("Wooden_Sword.png"), 220, 220);
        RING_OF_LESSER_RESTORATION = new Sprite(new Texture("Ring_Of_Lesser_Restoration.png"), 220, 220);
        LEATHER_ARMOR = new Sprite(new Texture("Leather_Armor.png"), 183, 219);
        SHARP_SWORD = new Sprite(new Texture("Sharp_Sword.png"), 220, 220);
        RING_OF_RESTORATION = new Sprite(new Texture("Ring_Of_Restoration.png"), 220, 220);
        CHAIN_MAIL = new Sprite(new Texture("Chain_Mail.png"), 183, 219);
        FIEND_SLASHER = new Sprite(new Texture("Fiend_Slasher.png"), 220, 220);
        RING_OF_GREATER_RESTORATION = new Sprite(new Texture("assets/Ring_Of_Greater_Restoration.png"), 220, 220);
        ENCHANTED_ARMOR = new Sprite(new Texture("Enchanted_Armor.png"), 183, 219);
        HEROES_RING_OF_IMMORTALITY = new Sprite(new Texture("Hero's_Ring_Of_Immortality.png"), 220, 220);
        ANCIENT_DRAGON_SCALE_MAIL = new Sprite(new Texture("Ancient_Dragon's_Scale_Mail.png"), 183, 219);
        KNIGHT = new AnimationHandler("Knight_Idle.png", 6);
        BARBARIAN = new AnimationHandler("Barbarian_Idle.png", 6);
        BARD = new AnimationHandler("Bard_Idle.png", 6);
        CLERIC = new AnimationHandler("Cleric_Idle.png", 6);
        DRUID = new AnimationHandler("Druid_Idle.png", 6);
        MONK = new AnimationHandler("Monk_Idle.png", 6);
        PALADIN = new AnimationHandler("Paladin_Idle.png", 6);
        ROUGE = new AnimationHandler("Rouge_Idle.png", 6);
        WIZARD = new AnimationHandler("Wizard_Idle.png", 6);
        SKELETON = new AnimationHandler("Skeleton_Idle.png", 4);
    }
}
