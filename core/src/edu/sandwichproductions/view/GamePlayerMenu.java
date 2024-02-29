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
        menuBody = new Sprite(new Texture("Character_Screen_Background.png"), 1120, 1360);
        menuBody.setX(1420);
        menuBody.setY(20);
        menuScreen = new Sprite(new Texture("bossroom.png"), 1040, 550);
        weaponSlot = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 250, 250);
        armourSlot = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 250, 250);
        healthSlot = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 250, 250);
        weapon = new Sprite(new Texture("placeholder.png"));
        armour = new Sprite(new Texture("placeholder.png"));
        health = new Sprite(new Texture("placeholder.png"));
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(menuBody, 1420, 20);
        batch.draw(menuScreen, getMenuScreenX(), getMenuScreenY());
        batch.draw(weaponSlot, 1460 , menuScreen.getY() - (250 + 10));
        batch.draw(armourSlot, 1855, menuScreen.getY() - (250 + 10));
        batch.draw(healthSlot, 2250, menuScreen.getY() - (250 + 10));
        batch.draw(weapon, 1475, 560);
        batch.draw(armour, 1870, 560);
        batch.draw(health, 2265, 560);
        batch.end();
    }

    public int getMenuScreenX() {
        int menuBodyX = (int) (menuBody.getX() + 40);
        menuScreen.setX(menuBodyX);
        return menuBodyX;
    }

    public int getMenuScreenY() {
        int menuBodyY = (int) ((menuBody.getHeight() - menuScreen.getHeight()) - 8);
        menuScreen.setY(menuBodyY);
        return menuBodyY;
    }

    public Sprite getWeapon() {
        return this.weapon;
    }

    public void setWeaponSprite(Sprite sprite) {
        this.weapon = sprite;
    }

    public Sprite getHealth() {
        return this.health;
    }

    public void setHealthSprite(Sprite sprite) {
        this.health = sprite;
    }

    public Sprite getArmour() {
        return this.armour;
    }

    public void setArmourSprite(Sprite sprite) {
        this.armour = sprite;
    }
}
