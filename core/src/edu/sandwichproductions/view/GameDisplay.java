package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.map.Room;

public class GameDisplay {
    private GameController controller;
    private GameEntitySprite entity;
    private GameMap map;
    private GamePlayerMenu menu;
    private SpriteBatch batch;
    private Sprite character;
    private Sprite enemy;
    private Sprite room;
    private Sprite enemyRoom;
    private Sprite bossRoom;
    private Player player;
    private int floorWidth;
    private int floowHeight;
    private int currentPlayerPosition;

    public GameDisplay() {
        controller = new GameController();
        batch = new SpriteBatch();
        map = new GameMap();
        menu = new GamePlayerMenu();
        entity = new GameEntitySprite();
        character = entity.getCharacter();
        enemy = entity.getEnemy();
        room = map.getRoom();
        enemyRoom = map.getEnemyRoom();
        bossRoom = new Sprite(new Texture("bossroom.png"), 195, 195);
        player = controller.getPlayer();
        floorWidth = map.getFloorWidth();
        floowHeight = map.getFloorHeight();
        controller.run();
    }

    public void update() {
        if (player.isAlive()) {
            controller.getMyMovement().move(player);
            if (controller.getMyMovement().checkForEnemy(player.getPositionInRoom()) != null) {
                controller.getMyCombat().fight(player, controller.getMyMovement().checkForEnemy(player.getPositionInRoom()));
                removeEnemy();
            }
            entity.setCharacterRoomPositions(player);
            entity.updateCharacterPosition(floorWidth, floowHeight);
            drawMap();
            menu.draw(batch);
        } else {
            disposeBatch();
        }
    }

    public void disposeBatch() {
        batch.dispose();
    }

    public void drawMap() {
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
        batch.draw(character, entity.getCharacterXPosition(), entity.getCharacterYPosition());
        batch.end();
    }

    public Room getRoom() {
        return controller.getRooms()[currentPlayerPosition / 5][currentPlayerPosition % 5];
    }

    public int getEnemyPosition(int column) {
        return getRoom().getEnemies()[column].getPositionInRoom();
    }

    public int setEnemyX(int column) {
        return (getEnemyPosition(column) / 7) * (floorWidth + 1) + entity.getEntityDimension() + 40;
    }

    public int setEnemyY(int column) {
        return (getEnemyPosition(column) % 7) * (floowHeight + 1) + entity.getEntityDimension();
    }

    public void drawRoom(Sprite room) {
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 7; column++) {
                batch.draw(room, row * (floorWidth + 1), column * (floowHeight + 1));
            }
        }
    }

    public void drawEntities(int amountOfEnemies) {
        for (int i = 0; i < amountOfEnemies; i++) {
            if (getRoom().getEnemies()[i] != null) {
                batch.draw(enemy, setEnemyX(i), setEnemyY(i));
            }
        }
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

