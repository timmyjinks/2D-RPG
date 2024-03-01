package edu.sandwichproductions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.controller.GameStatus;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Stick;

public class GameDisplay {
    private GameController controller;
    private GameMap map;
    private GamePlayerMenu menu;
    private Player player;
    private BitmapFont fightDetails;

    public GameDisplay() {
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
            menu.draw();
            menu.drawHotBar(player);
            menu.displayInventorySwap(player);
            menu.drawInventory(player);
            ItemSprite.BATCH.begin();
            fightDetails.draw(ItemSprite.BATCH, "Test Text ksjdfkdjkfdjfkdjfkdj\nskdjfkdjfkdjfkdjf\nkdsjfkdjfkdjdsfdf\n\n\ndfsd", 1460, 1345);
            ItemSprite.BATCH.end();
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
        player.setWeapon(new Stick());
        player.setRing(new HealingItem("Healing Potion", 5, 2, 6, 5, ItemSprite.RING));
        player.setHealth(5);
    }
}