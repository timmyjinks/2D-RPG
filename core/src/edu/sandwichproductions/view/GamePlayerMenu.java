package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.model.entity.Player;

public class GamePlayerMenu {
    private SpriteBatch batch;
    private Sprite placeholder;
    private Sprite characterItemSlot = new Sprite(new Texture("Character_Screen_Item_Slot.png"), 208, 208);
    private Sprite menuBody;
    private Sprite menuScreen;
    private Sprite weaponSlot;
    private Sprite armourSlot;
    private Sprite healthSlot;
    private Sprite weapon;
    private Sprite armour;
    private Sprite health;

    public GamePlayerMenu() {
        batch = new SpriteBatch();
        placeholder = new Sprite(new Texture("assets/placeholder.png"), 178, 178);
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

    public void draw() {
        this.batch.begin();
        this.batch.draw(menuBody, 1420, 20);
        this.batch.draw(menuScreen, getMenuScreenX(), getMenuScreenY());
        this.batch.draw(weaponSlot, 1460 , menuScreen.getY() - (250 + 10));
        this.batch.draw(armourSlot, 1855, menuScreen.getY() - (250 + 10));
        this.batch.draw(healthSlot, 2250, menuScreen.getY() - (250 + 10));
        this.batch.draw(weapon, 1475, 560);
        this.batch.draw(armour, 1870, 560);
        this.batch.draw(health, 2265, 560);
        this.batch.end();
    }

    public void drawInventory(Player player) {
        int row = 0;
        int x, y;
        batch.begin();
        for (int inventoryIndex = 0; inventoryIndex < player.getInventory().length; inventoryIndex++) {
            if (inventoryIndex % 5 == 0 && inventoryIndex != 0) {
                row++;
            }
            x = inventoryIndex % 5 * (208 + 1) + 1460;
            y = row * (208 + 1) + 60;
            batch.draw(characterItemSlot, x, y);
            if (player.getInventory()[inventoryIndex] == null) {
                batch.draw(placeholder, inventoryIndex % 5 + x + 1, row + y + 1);
            } else {
          //      batch.draw(player.getInventory()[inventoryIndex].getItemSprite(), inventoryIndex % 5 + x + 1 + 15, row + y + 1 + 15);
            }
        }
        batch.end();
    }

    public void drawHotBar(Player player) {
        player.getWeapon().setItemSprite("assets/room.png");
        setWeaponSprite(player.getWeapon().getItemSprite());
        if (player.getArmour() == null) {
            setArmourSprite(placeholder);
        } else {
            setArmourSprite(player.getArmour().getItemSprite());
        }
        if (player.getRing() == null) {
            setHealthSprite(placeholder);
        } else {
            setHealthSprite(player.getRing().getItemSprite());
        }
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
