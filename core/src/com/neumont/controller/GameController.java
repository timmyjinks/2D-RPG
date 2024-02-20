package com.neumont.controller;

import com.neumont.model.map.Map;
import com.neumont.view.Menu;
import com.neumont.model.entity.Player;

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
