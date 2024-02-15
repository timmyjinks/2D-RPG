package org.example;

import org.example.controller.GameController;
import de.gurkenlabs.litiengine.Game;

public class Main {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.startHere();
        Game.init(args);
        Game.start();
    }
}