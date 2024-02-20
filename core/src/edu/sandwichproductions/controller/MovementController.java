package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.view.MyIO;
import edu.sandwichproductions.model.entity.Player;

public class MovementController {
    private Map world;
    private MyIO inputOutput = new MyIO();

    public MovementController(Map world) {
        this.world = world;
    }

    public void move(Player myplayer) {
        // room array position = roomPosition[int/7][int%7]
        int move = 0; // get player position in room
        char movementDirection = 'u';
        while (movementDirection != 'p') {
            movementDirection = inputOutput.charInput("Use W,A,S,D to move. I for inventory. And P to exit");
            move = myplayer.getPositionInRoom();
            switch (movementDirection) {
                case 'w':
                    // movement up will decrement integer by 7
                    myplayer.setPositionInRoom(vertical(move, 0, 0, -7));
                    break;
                case 's':
                    // movement down will increment integer by 7
                    myplayer.setPositionInRoom(vertical(move, 6, 4, 7));
                    break;
                case 'a':
                    // movement left will decrement integer by 1
                    myplayer.setPositionInRoom(horizontal(move, 0, 0, -1));
                    break;
                case 'd':
                    // movement right will increment integer by 1
                    myplayer.setPositionInRoom(horizontal(move, 6, 4, 1));
                    break;
            }
        }
    }

    //    public void move(int move) {
//        // roomPosition[move/7][move%7].setPlayer();
//    }
    //region movement directions
    public int horizontal(int move, int bounds, int worldDirection, int posMod) {
        if (move % 7 != bounds) {
            move += posMod;
        } else {
            int moveRoom = world.getPlayerWorldPosition();
            if (moveRoom % 5 != worldDirection) {
                if (bounds == 0) {
                    moveRoom -= 1;
                    move += 6;
                    world.setPlayerWorldPosition(moveRoom, 1);
                } else {
                    moveRoom += 1;
                    move -= 6;
                    world.setPlayerWorldPosition(moveRoom, -1);
                }
            }
        }
        return move;
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
}