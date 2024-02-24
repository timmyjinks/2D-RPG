package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Skeleton;
import edu.sandwichproductions.model.map.BossRoom;
import edu.sandwichproductions.model.map.SpawnRoom;
import edu.sandwichproductions.model.map.Room;

import java.util.Random;

public class MapGenerator {

    Random myRandom = new Random();
    Enemy[] enemies = new Enemy[7];
    boolean hasBossRoom = false;

    public void generateMap(Room[][] myRooms){
        // generates all rooms on the map
        for (int row = 0; row < 5; row++){
            for (int column = 0; column < 5; column++){
                if (row == 2 && column == 2){
                    myRooms[row][column] = new SpawnRoom();
                } else if (isEdgeOfMap(row, column) && !hasBossRoom && spawnBossRoom()) {
                    myRooms[row][column] = new BossRoom();
                    myRooms[row][column].setRoomNumber((row*5) + column);
                    hasBossRoom = true;
                } else {
                    myRooms[row][column] = new Room();
                    myRooms[row][column].setEnemyRoom(true);
                    // gives each of the 25 rooms a unique number between 0 and 24
                    myRooms[row][column].setRoomNumber((row*5) + column);
                    // sets each position in the room to increasing integer values (start 0, end 48)
                    myRooms[row][column].setRoomPositions(populateRooms());
                    myRooms[row][column].setEnemies(enemies);
                    enemies = new Enemy[7];

                }
            }
        }
    }
    public int[][] populateRooms() {
        int[][] myIntArray = new int[7][7];
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 7; column++) {
                if (tileIsEnemy()) {
                    Enemy enemy = new Skeleton("Skeleton");
                    enemy.setPositionInRoom((row * 7) + column);
                    for (int i = 0; i < enemies.length; i++) {
                        if (enemies[i] == null) {
                            enemies[i] = enemy;
                            break;
                        }
                    }
                }
                myIntArray[row][column] = (row * 7) + (column);
            }
        }
        return myIntArray;
    }

    public boolean tileIsEnemy() {
        return myRandom.nextInt(100) + 1 <= 25;
    }

    public boolean isEdgeOfMap(int row, int column) {
        return (row == 0 || row == 4) || (column == 0 || column == 4);
    }

    public boolean spawnBossRoom() {
        return myRandom.nextInt(15) <= 2;
    }
}