package edu.sandwichproductions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.AnimationHandler;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.controller.PlayerStatus;
import edu.sandwichproductions.model.entity.Player;
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
        player.setWeapon(new Stick("Stick", 10, 4, 1, 0, "assets/room.png"));
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
            menu.draw();
            menu.drawHotBar(player);
//            drawInventory();
            return true;
        } else {
            PlayerStatus.setStatus(true);
            return false;
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
        int offSet = 0;
        int x, y;
        batch.begin();
        for (int inventoryIndex = 0; inventoryIndex < player.getInventory().length; inventoryIndex++) {
            if (inventoryIndex % 5 == 0 && inventoryIndex != 0) {
                offSet++;
            }
            x = inventoryIndex % 5 * (208 + 1) + 1460;
            y = offSet * (208 + 1) + 60;
            batch.draw(new Sprite(new Texture("room.png"), 208, 208),x , y);
            batch.draw(new Sprite(new Texture("Sky_Render.png"), 178, 178), inventoryIndex % 5 + x + 1, offSet + y + 1);
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
}

