package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.AnimationHandler;

public class ItemSprite {
    public static final SpriteBatch BATCH = new SpriteBatch();
    public static final Sprite ROOM = new Sprite(new Texture("room.png"), 199, 199);
    public static final Sprite ENEMY_R00M = new Sprite(new Texture("enemyroom.png"), 199, 199);
    public static final Sprite BOSS_ROOM = new Sprite(new Texture("bossroom.png"), 199, 199);
    public static final Sprite PLACEHOLDER = new Sprite(new Texture("assets/placeholder.png"), 220, 220);
    public static final Sprite CHARACTER_ITEM_SLOT = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 208, 208);
    public static final Sprite MENU_BODY = new Sprite(new Texture("Character_Screen_Background.png"), 1120, 1360);
    public static final Sprite STICK = new Sprite(new Texture("Stick.png"), 220, 220);
    public static final Sprite SKY_RENDER = new Sprite(new Texture("Sky_Render.png"), 220, 220);
    public static final Sprite RING = new Sprite(new Texture("assets/Ring_Of_Greater_Restoration.png"), 220, 220);
    public static final AnimationHandler KNIGHT = new AnimationHandler("Knight_Idle.png", 6);
    public static final AnimationHandler SKELETON = new AnimationHandler("Skeleton_Idle.png", 4);
}
