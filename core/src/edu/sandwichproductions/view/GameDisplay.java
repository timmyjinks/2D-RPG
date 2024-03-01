package edu.sandwichproductions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.controller.PlayerStatus;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Stick;

public class GameDisplay {
    private GameController controller;
    private GameMap map;
    private GamePlayerMenu menu;
    private Player player;

    public GameDisplay() {
        controller = new GameController();
        controller.run();
        menu = new GamePlayerMenu();
        map = new GameMap(controller.getWorld());
        player = controller.createPlayer();
        createPlayer();
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
            return quit();
        } else {
            return false;
        }
    }

    public boolean quit() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            PlayerStatus.setStatus(true);
            return false;
        }
        return true;
    }

    public void createPlayer() {
        player.setWeapon(new Stick("Stick", 10, 4, 1, 0, ItemSprite.STICK));
        player.setRing(new HealingItem("Healing Potion", 5, 2, 6, 5, ItemSprite.RING));
        player.setHealth(999999999);
    }
}