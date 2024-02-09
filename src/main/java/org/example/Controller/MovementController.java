package org.example.Controller;

import org.example.View.MyIO;

public class MovementController {
    private MyIO inputOutput = new MyIO();

    public void move() {
        // room array position = roomPosition[int/7][int%7]
        int move = 0; // get player position in room
        int movementDirection = inputOutput.intInput("1) move up \n 2) move down \n 3) move left \n 4) move right");
        switch (movementDirection) {
            case 1:
                // movement up will decrement integer by 7
                move(up(move));
                break;
            case 2:
                // movement down will increment integer by 7
                move(down(move));
                break;
            case 3:
                // movement left will decrement integer by 1
                move(left(move));
                break;
            case 4:
                // movement right will increment integer by 1
                move(right(move));
                break;
        }
    }

    public void move(int move) {
        // roomPosition[move/7][move%7].setPlayer();
    }

    //region movement directions
    public int left(int move) {
        move -= 1;
        if ((move + 7) % 7 == 6) {
            move += 1;
        }
        return move;
    }

    public int right(int move) {
        move += 1;
        if (move % 7 == 0) {
            move -= 1;
        }
        return move;
    }

    public int up(int move) {
        move -= 7;
        if (move / 7 == -1) {
            move += 7;
        }
        return move;
    }

    public int down(int move) {
        move += 7;
        if (move / 7 == 8) {
            move -= 7;
        }
        return move;
    }
    //endregion
}
