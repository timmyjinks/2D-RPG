package edu.sandwichproductions.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.model.entity.Player;

public class MovementController {
    private Map world;
    public MovementController(Map world) {
        this.world = world;
    }

    public void move(Player myplayer) {
        // room array position = roomPosition[int/7][int%7]
        int roomPosition; // get player position in room
        roomPosition = myplayer.getPositionInRoom();
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            // movement up will decrement integer by 7
            myplayer.setPositionInRoom(vertical(roomPosition, 0, 0, -7));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            // movement down will increment integer by 7
            myplayer.setPositionInRoom(vertical(roomPosition, 6, 4, 7));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            // movement left will decrement integer by 1
            myplayer.setPositionInRoom(horizontal(roomPosition, 0, 0, -1));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            // movement right will increment integer by 1
            myplayer.setPositionInRoom(horizontal(roomPosition, 6, 4, 1));
        }
    }
    //    public void move(int move) {
//        // roomPosition[move/7][move%7].setPlayer();
//    }
    //region movement directions
    public int horizontal(int roomPosition, int bounds, int worldDirection, int posMod) {
        if (roomPosition % 7 != bounds) {
            roomPosition += posMod;
        } else {
            int moveRoom = world.getPlayerWorldPosition();
            if (moveRoom % 5 != worldDirection) {
                if (bounds == 0) {
                    moveRoom -= 1;
                    roomPosition += 6;
                    world.setPlayerWorldPosition(moveRoom, 1);
                } else {
                    moveRoom += 1;
                    roomPosition -= 6;
                    world.setPlayerWorldPosition(moveRoom, -1);
                }
            }
        }
        return roomPosition;
    }

    public int vertical(int move, int bounds, int worldDirection, int posMod) {
        if (move / 7 != bounds) {
            move += posMod;
        } else {
            int moveRoom = world.getPlayerWorldPosition();
            if (moveRoom / 5 != worldDirection) {
                if (bounds == 0) {
                    moveRoom -= 5;
                    move += 42;
                    world.setPlayerWorldPosition(moveRoom, 5);
                } else {
                    moveRoom += 5;
                    move -= 42;
                    world.setPlayerWorldPosition(moveRoom, -5);
                }
            }
        }
        return move;
    }
    //endregion

    public Enemy checkForEnemy(int roomPosition) {
        int worldPosition = world.getPlayerWorldPosition();
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 7; column++) {
                for (Enemy enemy : world.getRooms()[worldPosition/5][worldPosition%5].getEnemies()) {
                    if (enemy != null) {
                        if (enemy.getPositionInRoom() == roomPosition) {
                            return enemy;
                        }
                    }
                }
            }
        }
        return null;
    }
}