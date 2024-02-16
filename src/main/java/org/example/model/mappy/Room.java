package org.example.model.mappy;

public class Room {
    protected int roomNumber;
    protected int[][] roomPositions = new int[7][7];
    protected boolean isEnemyRoom = false;
    protected boolean hasPlayer = false;
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
}
