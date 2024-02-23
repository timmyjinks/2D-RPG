package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.map.Room;

public class GameDisplay {
    private GameController controller;
    private GameEntitySprite entity;
    private GameMap map;
    private SpriteBatch batch;
    private Sprite character;
    private Sprite enemy;
    private Sprite room;
    private Sprite enemyRoom;
    private Player player;
    private int floorWidth;
    private int floowHeight;
    private int currentPlayerPosition;

    public GameDisplay() {
        controller = new GameController();
        batch = new SpriteBatch();
        map = new GameMap();
        entity = new GameEntitySprite();
        character = entity.getCharacter();
        enemy = entity.getEnemy();
        room = map.getRoom();
        enemyRoom = map.getEnemyRoom();
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
            }
            entity.setCharacterRoomPositions(player);
            entity.updateCharacterPosition(floorWidth, floowHeight);
            drawMap();
            System.out.println(player.getHealth());
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
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 7; column++) {
                if (getRoom().isEnemyRoom()) {
                    batch.draw(map.getEnemyRoom(), row * (floorWidth + 1), column * (floowHeight + 1));
                    if (getRoom().getEnemies()[column] != null) {
                        batch.draw(enemy, setEnemyX(column), setEnemyY(column));
                    }
                } else {
                    batch.draw(room, row * (floorWidth + 1), column * (floowHeight + 1));
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
}

