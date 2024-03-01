package edu.sandwichproductions.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.model.map.Room;

public class GameMap {
    private SpriteBatch batch;
    private GameEntitySprite entity;
    private Sprite room;
    private Sprite enemyroom;
    private Map world;
    private int floorWidth;
    private int floorHeight;
    private int currentPlayerPosition;
    private float elapsedTime;

    public GameMap(Map world) {
        batch = ItemSprite.BATCH;
        entity = new GameEntitySprite();
        room = ItemSprite.ROOM;
        enemyroom = ItemSprite.ENEMY_R00M;
        this.world = world;
        elapsedTime = 0;
        floorWidth = (int) room.getWidth();
        floorHeight = (int) room.getHeight();
    }

    public void drawMap(int playerWorldPosition) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        this.currentPlayerPosition = playerWorldPosition;
        batch.begin();
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (getRoom().isBossRoom()) {
                    drawRoom(ItemSprite.BOSS_ROOM);
                    drawEntities(1);
                } else if (getRoom().isEnemyRoom()) {
                    drawRoom(ItemSprite.ENEMY_R00M);
                    drawEntities(getRoom().getEnemies().length);
                } else {
                    drawRoom(ItemSprite.ROOM);
                }
            }
        }
        batch.draw(ItemSprite.KNIGHT.getKeyFrame(elapsedTime, true), entity.getCharacterXPosition(), entity.getCharacterYPosition());
        ItemSprite.BATCH.end();
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
                batch.draw(ItemSprite.SKELETON.getKeyFrame(elapsedTime, true), setEnemyX(i), setEnemyY(i));
            }
        }
    }

    public void removeEnemy() {
        for (int i = 0; i < getRoom().getEnemies().length; i++) {
            if (!(getRoom().getEnemies()[i] == null)) {
                if (!getRoom().getEnemies()[i].isAlive()) {
                    getRoom().getEnemies()[i] = null;
                }
            }
        }
    }

    public void updateCharacterPosition(Player player) {
        entity.setCharacterRoomPositions(player);
        entity.updateCharacterPosition(getFloorWidth(), getFloorHeight());
    }

    public Room getRoom() {
        return world.getRooms()[currentPlayerPosition / 5][currentPlayerPosition % 5];
    }

    public int getEnemyPosition(int column) {
        return getRoom().getEnemies()[column].getPositionInRoom();
    }

    public int setEnemyX(int column) {
        return (getEnemyPosition(column) / 7) * (floorWidth + 1) + entity.getEntityDimension() + ItemSprite.SKELETON.getCenter();
    }

    public int setEnemyY(int column) {
        return (getEnemyPosition(column) % 7) * (floorHeight + 1) + entity.getEntityDimension();
    }

    public int getFloorWidth() {
        return floorWidth;
    }

    public int getFloorHeight() {
        return floorHeight;
    }
}
