package edu.sandwichproductions.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameMap {
    private Sprite room;
    private Sprite enemyRoom;
    private int floorWidth;
    private int floorHeight;

    public GameMap() {
        room = new Sprite(new Texture("room.png"), 180, 180);
        enemyRoom = new Sprite(new Texture("enemyroom.png"), 180, 180);
        floorWidth = (int) room.getWidth();
        floorHeight = (int) room.getHeight();
    }

    public Sprite getRoom() {
        return room;
    }

    public void setRoom(Sprite room) {
        this.room = room;
    }

    public Sprite getEnemyRoom() {
        return enemyRoom;
    }

    public void setEnemyRoom(Sprite enemyRoom) {
        this.enemyRoom = enemyRoom;
    }

    public int getFloorWidth() {
        return floorWidth;
    }

    public void setFloorWidth(int floorWidth) {
        this.floorWidth = (int) room.getWidth();
    }

    public int getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight() {
        this.floorHeight = (int) room.getHeight();
    }
}
