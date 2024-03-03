package edu.sandwichproductions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.util.GameStatus;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.BrokenRing;
import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.util.ItemSprite;

public class GameDisplay {
    private SpriteBatch batch;
    private GameController controller;
    private GameMap map;
    private GamePlayerMenu menu;
    private Player player;
    private BitmapFont fightDetails;

    public GameDisplay() {
        ItemSprite.refresh();
        batch = new SpriteBatch();
        controller = new GameController();
        controller.run();
        player = controller.createPlayer();
        createPlayer();
        map = new GameMap(controller.getWorld(), player);
        menu = new GamePlayerMenu();
        fightDetails = new BitmapFont(Gdx.files.internal("font.fnt"));
    }

    public boolean update() {
        if (player.isAlive()) {
            quit();
            controller.getMyMovement().move(player);
            if (controller.getMyMovement().checkForEnemy(player.getPositionInRoom()) != null) {
                controller.getMyCombat().fight(player, controller.getMyMovement().checkForEnemy(player.getPositionInRoom()));
                map.removeEnemy();
            }
            map.updateCharacterPosition(player);
            map.drawMap(controller.getWorld().getPlayerWorldPosition());
            menu.drawMenu(player);
            drawFightLog();
            return quit();
        } else {
            GameStatus.setPlayerStatus(false);
            return false;
        }
    }

    public boolean quit() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            GameStatus.setPlayerStatus(false);
            return false;
        }
        return true;
    }

    public void createPlayer() {
        player.setWeapon(new DamageItem("Great Axe", 15, 8, 2, 3, ItemSprite.STICK));
        player.setRing(new BrokenRing());
        player.setHealth(50);
        player.setSprite();
    }

    public void drawFightLog() {
        batch.begin();
        fightDetails.draw(batch,controller.getMyCombat().getFightLog(), 1460, 1360);
        batch.end();
    }
}