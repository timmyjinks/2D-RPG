package edu.sandwichproductions.controller;

public class GameStatus {
    private static boolean playerStatus = true;
    private static boolean gameStatus = true;

    public static boolean getGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(boolean gameStatus) {
        GameStatus.gameStatus = gameStatus;
    }
    public static boolean getPlayerStatus() {
        return playerStatus;
    }

    public static void setPlayerStatus(boolean playerStatus) {
        GameStatus.playerStatus = playerStatus;
    }
}
