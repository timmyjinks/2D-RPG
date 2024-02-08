package org.example.Model.MapStuff;

public class Room {
    private int[][] roomPositions = new int[7][7];
    private boolean isEnemyRoom = false;
    public int[][] getRoomPositions(){
        return roomPositions;
    }
    public void setRoomPositions(int[][] roomPositions){
        this.roomPositions = roomPositions;
    }
    public void setEnemyRoom(boolean isEnemyRoom){
        this.isEnemyRoom = isEnemyRoom;
    }
}
