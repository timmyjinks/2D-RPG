package org.example.Model.MapStuff;

import org.example.Controller.MapGenerator;

public class Map {
    private Room[][] rooms = new Room[5][5];
    public Map (){
        MapGenerator myMapGenerator = new MapGenerator();
        myMapGenerator.generateMap(rooms);
    }
    public Room[][] getRooms(){
        return rooms;
    }
}
