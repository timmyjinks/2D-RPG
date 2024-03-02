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
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Stick;
import edu.sandwichproductions.util.ItemSprite;

public class GameDisplay {
    private SpriteBatch batch;
    private GameController controller;
    private GameMap map;
    private GamePlayerMenu menu;
    private Player player;
    private BitmapFont fightDetails;
    private ItemSprite itemSprite;

    public GameDisplay() {
        ItemSprite.refresh();
        itemSprite = new ItemSprite();
        batch = new SpriteBatch();
        controller = new GameController();
        controller.run();
        menu = new GamePlayerMenu();
        map = new GameMap(controller.getWorld());
        player = controller.createPlayer();
        createPlayer();
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
            batch.begin();
            fightDetails.draw(batch, "Test Text ksjdfkdjkfdjfkdjfkdj\nskdjfkdjfkdjfkdjf\nkdsjfkdjfkdjdsfdf\n\n\ndfsd", 1460, 1345);
            batch.end();
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
        player.setWeapon(new DamageItem("Great Axe", 15, 8, 3, 3, ItemSprite.STICK));
        player.setRing(new BrokenRing());
        player.setHealth(100);
    }
}