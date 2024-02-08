package org.example.Controller;

import org.example.Model.MapStuff.Room;

import java.util.Random;

public class MapGenerator {

    Random myRandom = new Random();
    public void generateMap(Room[][] myRooms){
        // generates all rooms on the map
        for (int row = 0; row < 5; row++){
            for (int column = 0; column < 5; column++){
                myRooms[row][column] = new Room();
                // sets each position in the room to increasing integer values (start 0, end 48)
                myRooms[row][column].setEnemyRoom(isEnemyRoom());
                myRooms[row][column].setRoomPositions(populateRooms());
            }
        }
    }
    public int[][] populateRooms(){
        int[][] myIntArray = new int[7][7];
        for (int row = 0; row < 7; row++){
            for (int column = 0; column < 7; column++){
                myIntArray[row][column] = (row*7) + (column);
            }
        }
        return myIntArray;
    }
    public boolean isEnemyRoom(){
        // set isEnemyRoom boolean value in each room based on number generated (10% chance to be enemy room)
        return (myRandom.nextInt(100) + 1) <= 10;
    }
}
