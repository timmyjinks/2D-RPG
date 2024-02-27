package edu.sandwichproductions.controller;

public class PlayerStatus {
    private static boolean status = false;

    public static void setStatus(boolean playerStatus) {
        status = playerStatus;
    }

    public static boolean getStatus() {
        return status;
    }
}
