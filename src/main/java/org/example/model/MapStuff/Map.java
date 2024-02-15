package org.example.model.MapStuff;

import org.example.controller.MapGenerator;

public class Map {
    private int playerWorldPosition;
    private Room[][] rooms = new Room[5][5];
    public Map (){
        MapGenerator myMapGenerator = new MapGenerator();
        myMapGenerator.generateMap(rooms);
        this.playerWorldPosition = 12;
    }
    public void setPlayerWorldPosition(int position, int worldPosMod){
        this.playerWorldPosition = position;
        rooms[position/5][position%5].setHasPlayer(true);
        position += worldPosMod;
        rooms[position/5][position%5].setHasPlayer(false);
    }

    public int getPlayerWorldPosition() {
        return playerWorldPosition;
    }

    public Room[][] getRooms(){
        return rooms;
    }
}
