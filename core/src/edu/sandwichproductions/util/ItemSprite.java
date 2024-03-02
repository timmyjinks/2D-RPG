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
    public static Sprite STICK;
    public static Sprite SKY_RENDER;
    public static Sprite RING;
    public static AnimationHandler KNIGHT;
    public static AnimationHandler SKELETON;

    public static void refresh() {
        ROOM = new Sprite(new Texture("room.png"), 199, 199);
        ENEMY_R00M = new Sprite(new Texture("enemyroom.png"), 199,199);
        BOSS_ROOM = new Sprite(new Texture("bossroom.png"), 199, 199);
        MENU_BODY = new Sprite(new Texture("Character_Screen_Background.png"), 1160, 1400);
        CHARACTER_ITEM_SLOT = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 250, 250);
        INVENTORY_ITEM_SLOT = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 208, 208);
        PLACEHOLDER = new Sprite(new Texture("assets/placeholder.png"), 220, 220);
        STICK = new Sprite(new Texture("Stick.png"), 220, 220);
        SKY_RENDER = new Sprite(new Texture("Sky_Render.png"), 220, 220);
        RING = new Sprite(new Texture("assets/Ring_Of_Greater_Restoration.png"), 220, 220);
        KNIGHT = new AnimationHandler("Knight_Idle.png", 6);
        SKELETON = new AnimationHandler("Skeleton_Idle.png", 4);
    }
}
