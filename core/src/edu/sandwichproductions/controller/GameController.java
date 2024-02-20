package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.view.Menu;
import edu.sandwichproductions.model.entity.Player;

public class GameController {
    private Map world;
    private Menu menu = new Menu();
    private Player player;
    private MovementController myMovement;
    private CombatController myCombat = new CombatController();
    private int selection = 0;

    public void run(){
        while (selection != 3) {
            selection = menu.startMenu();
            switch (selection) {
                case 1 -> startGame();
                case 2 -> menu.settingsMenu();
            }
        }
    }

    public void startGame() {
        world = new Map();
        myMovement = new MovementController(world);
        // character selection
    }
}
