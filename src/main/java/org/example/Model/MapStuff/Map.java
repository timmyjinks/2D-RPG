package org.example.Model.MapStuff;

import org.example.Controller.MapGenerator;

public class Map {
    private int playerWorldPosition;
    private Room[][] rooms = new Room[5][5];
    public Map (){
        MapGenerator myMapGenerator = new MapGenerator();
        myMapGenerator.generateMap(rooms);
    }
    public void setPlayerWorldPosition(int position){
        this.playerWorldPosition = position;
    }

    public int getPlayerWorldPosition() {
        return playerWorldPosition;
    }

    public Room[][] getRooms(){
        return rooms;
    }
}
