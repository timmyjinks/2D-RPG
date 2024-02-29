package edu.sandwichproductions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.controller.PlayerStatus;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.DamageItem;
import edu.sandwichproductions.model.item.DefenseItem;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.model.item.Stick;
import edu.sandwichproductions.model.map.Room;

public class GameDisplay {
    private GameController controller;
    private GameEntitySprite entity;
    private GameMap map;
    private GamePlayerMenu menu;
    private SpriteBatch batch;
    private AnimationHandler character;
    private AnimationHandler enemy;
    private Sprite room;
    private Sprite enemyRoom;
    private Sprite bossRoom;
    private Player player;
    private int floorWidth;
    private int floorHeight;
    private int currentPlayerPosition;
    private float elapsedTime = 0;

    public GameDisplay() {
        controller = new GameController();
        controller.run();
        batch = new SpriteBatch();
        map = new GameMap();
        menu = new GamePlayerMenu();
        entity = new GameEntitySprite();
        character = entity.getCharacter();
        enemy = entity.getEnemy();
        room = map.getRoom();
        enemyRoom = map.getEnemyRoom();
        bossRoom = new Sprite(new Texture("bossroom.png"), 195, 195);
        player = controller.createPlayer();
        createPlayer();
        floorWidth = map.getFloorWidth();
        floorHeight = map.getFloorHeight();
    }

    public boolean update() {
        if (player.isAlive()) {
            controller.getMyMovement().move(player);
            if (controller.getMyMovement().checkForEnemy(player.getPositionInRoom()) != null) {
                controller.getMyCombat().fight(player, controller.getMyMovement().checkForEnemy(player.getPositionInRoom()));
                removeEnemy();
            }
            entity.setCharacterRoomPositions(player);
            entity.updateCharacterPosition(floorWidth, floorHeight);
            drawMap();
            menu.draw(batch);
            drawHotBar();
            drawInventory();
            return true;
        } else {
            PlayerStatus.setStatus(true);
            return false;
        }
    }

    public void drawHotBar() {
        player.getWeapon().setItemSprite("assets/room.png");
        menu.setWeaponSprite(player.getWeapon().getItemSprite());

        if (player.getArmour() == null) {

            menu.setArmourSprite(new Sprite(new Texture("assets/placeholder.png")));
        } else {
            menu.setArmourSprite(player.getArmour().getItemSprite());
        }

        if (player.getRing() == null) {
            menu.setHealthSprite(new Sprite(new Texture("assets/placeholder.png")));
        } else {
            menu.setHealthSprite(player.getRing().getItemSprite());
        }
    }

    public void drawMap() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        currentPlayerPosition = controller.getWorld().getPlayerWorldPosition();
        batch.begin();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (getRoom().isBossRoom()) {
                    drawRoom(bossRoom);
                    drawEntities(1);
                } else if (getRoom().isEnemyRoom()) {
                    drawRoom(enemyRoom);
                    drawEntities(getRoom().getEnemies().length);
                } else {
                    drawRoom(room);
                }

            }
        }
        batch.draw(character.getKeyFrame(elapsedTime, true), entity.getCharacterXPosition(), entity.getCharacterYPosition());
        batch.end();
    }

    public Room getRoom() {
        return controller.getRooms()[currentPlayerPosition / 5][currentPlayerPosition % 5];
    }

    public int getEnemyPosition(int column) {
        return getRoom().getEnemies()[column].getPositionInRoom();
    }

    public int setEnemyX(int column) {
        return (getEnemyPosition(column) / 7) * (floorWidth + 1) + entity.getEntityDimension() + enemy.getCenter();
    }

    public int setEnemyY(int column) {
        return (getEnemyPosition(column) % 7) * (floorHeight + 1) + entity.getEntityDimension();
    }

    public void drawRoom(Sprite room) {
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 7; column++) {
                batch.draw(room, row * (floorWidth + 1), column * (floorHeight + 1));
            }
        }
    }

    public void drawEntities(int amountOfEnemies) {
        for (int i = 0; i < amountOfEnemies; i++) {
            if (getRoom().getEnemies()[i] != null) {
                batch.draw(enemy.getKeyFrame(elapsedTime, true), setEnemyX(i), setEnemyY(i));
            }
        }
    }

    public void drawInventory() {
        int row = 0;
        int x, y;
        batch.begin();
        for (int inventoryIndex = 0; inventoryIndex < player.getInventory().length; inventoryIndex++) {
            if (inventoryIndex % 5 == 0 && inventoryIndex != 0) {
                row++;
            }
            x = inventoryIndex % 5 * (208 + 1) + 1460;
            y = row * (208 + 1) + 60;
            batch.draw(new Sprite(new Texture("room.png"), 208, 208), x, y);
            if (player.getInventory()[inventoryIndex] == null) {
                batch.draw(new Sprite(new Texture("placeholder.png")), inventoryIndex % 5 + x + 1, row + y + 1);
            } else {
                batch.draw(player.getInventory()[inventoryIndex].getItemSprite(), inventoryIndex % 5 + x + 1 + 15, row + y + 1 + 15);
            }
        }
        batch.end();
    }

    public void removeEnemy() {
        for (int i = 0; i < 7; i++) {
            if (!(getRoom().getEnemies()[i] == null)) {
                if (!getRoom().getEnemies()[i].isAlive()) {
                    getRoom().getEnemies()[i] = null;
                }
            }
        }
    }

    public void createPlayer() {
        player.setWeapon(new Stick("Stick", 10, 4, 1, 0, "assets/room.png"));
        for (int i = 0; i < 5; i++) {
            player.getInventory()[i] = new HealingItem("Healing Potion", 5, 2, 6, 5, "assets/Ring_Of_Greater.png");
        }
    }
}

