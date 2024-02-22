package edu.sandwichproductions.controller;

import edu.sandwichproductions.Game;
import edu.sandwichproductions.model.entity.Barbarian;
import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.view.Menu;
import edu.sandwichproductions.model.entity.Player;

public class GameController {
    private Map world;
    private final Menu menu;
    private Player player = new Barbarian("John");
    private MovementController myMovement;
    private final CombatController myCombat;
    private int selection = 0;
    private Game game = new Game();

    public GameController() {
        menu = new Menu();
        myCombat = new CombatController();
    }

    public void run(){
        while (selection != 1) {
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
    }

    public MovementController getMyMovement() {
        return this.myMovement;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Map getWorld() {
        return this.world;
    }
}