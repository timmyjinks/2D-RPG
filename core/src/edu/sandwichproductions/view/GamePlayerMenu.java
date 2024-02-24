package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamePlayerMenu {
    private Sprite menuBody;
    private Sprite menuScreen;
    private Sprite weaponSlot;
    private Sprite armourSlot;
    private Sprite healthSlot;

    public GamePlayerMenu() {
        menuBody = new Sprite(new Texture("room.png"), 850, 1266);
        menuScreen = new Sprite(new Texture("bossroom.png"), 750, 550);
        weaponSlot = new Sprite(new Texture("MenuCover.png"), 180, 180);
        armourSlot = new Sprite(new Texture("MenuCover.png"), 180, 180);
        healthSlot = new Sprite(new Texture("MenuCover.png"), 180, 180);
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(menuBody, 1300, 0);
        batch.draw(menuScreen, 1350, 666);
        batch.draw(weaponSlot, 1350, 436);
        batch.draw(armourSlot, 1635, 436);
        batch.draw(healthSlot, 1920, 436);
        batch.end();
    }
}
