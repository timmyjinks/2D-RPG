package edu.sandwichproductions.model.map;

import edu.sandwichproductions.model.entity.Enemy;

public class Room {
    protected int roomNumber;
    protected int[][] roomPositions = new int[7][7];
    protected boolean isEnemyRoom = false;
    protected boolean isBossRoom = false;
    protected boolean hasPlayer = false;
    protected Enemy[] enemies = new Enemy[7];
    public int[][] getRoomPositions(){
        return roomPositions;
    }
    public void setRoomPositions(int[][] roomPositions){
        this.roomPositions = roomPositions;
    }
    public void setEnemyRoom(boolean isEnemyRoom){
        this.isEnemyRoom = isEnemyRoom;
    }
    public boolean isEnemyRoom() {
        return isEnemyRoom;
    }
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    public void setHasPlayer(boolean hasPlayer){
        this.hasPlayer = hasPlayer;
    }
    public int getRoomNumber(){
        return roomNumber;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public boolean isBossRoom() {
        return this.isBossRoom;
    }
}
