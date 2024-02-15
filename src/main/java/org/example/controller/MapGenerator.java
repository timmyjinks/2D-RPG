package org.example.controller;

import org.example.model.MapStuff.Room;
import org.example.model.MapStuff.SpawnRoom;

import java.util.Random;

public class MapGenerator {

    Random myRandom = new Random();
    public void generateMap(Room[][] myRooms){
        // generates all rooms on the map
        for (int row = 0; row < 5; row++){
            for (int column = 0; column < 5; column++){
                if (row == 2 && column == 2){
                    myRooms[row][column] = new SpawnRoom();
                } else {
                myRooms[row][column] = new Room();
                myRooms[row][column].setEnemyRoom(isEnemyRoom());
                // gives each of the 25 rooms a unique number between 0 and 24
                myRooms[row][column].setRoomNumber((row*5) + column);
                // sets each position in the room to increasing integer values (start 0, end 48)
                myRooms[row][column].setRoomPositions(populateRooms());
                }
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
