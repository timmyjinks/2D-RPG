package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamePlayerMenu {
    private Sprite menuBody;
    private Sprite menuScreen;
    private Sprite weaponSlot;
    private Sprite armourSlot;
    private Sprite healthSlot;
    private Sprite weapon;
    private Sprite armour;
    private Sprite health;

    public GamePlayerMenu() {
        menuBody = new Sprite(new Texture("room.png"), 1121, 1360);
        menuBody.setX(1419);
        menuBody.setY(20);
        menuScreen = new Sprite(new Texture("bossroom.png"), 1101, 550);
        weaponSlot = new Sprite(new Texture("MenuCover.png"), 180, 180);
        armourSlot = new Sprite(new Texture("MenuCover.png"), 180, 180);
        healthSlot = new Sprite(new Texture("MenuCover.png"), 180, 180);
        weapon = new Sprite(new Texture("bossroom.png"), 150, 150);
        armour = new Sprite(new Texture("bossroom.png"), 150, 150);
        health = new Sprite(new Texture("bossroom.png"), 150, 150);
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(menuBody, 1419, 20);
        batch.draw(menuScreen, getMenuScreenX(), getMenuScreenY());
        batch.draw(weaponSlot, 1429 , menuScreen.getY() - (180 + 10));
        batch.draw(armourSlot, 1890, menuScreen.getY() - (180 + 10));
        batch.draw(healthSlot, 2350, menuScreen.getY() - (180 + 10));
        batch.draw(weapon, 1444, 645);
        batch.draw(armour, 1905, 645);
        batch.draw(health, 2365, 645);
        batch.end();
    }

    public int getMenuScreenX() {
        int menuBodyX = (int) (menuBody.getX() + 10);
        menuScreen.setX(menuBodyX);
        return menuBodyX;
    }

    public int getMenuScreenY() {
        int menuBodyY = (int) ((menuBody.getHeight() - menuScreen.getHeight()) + 10);
        menuScreen.setY(menuBodyY);
        return menuBodyY;
    }
}
