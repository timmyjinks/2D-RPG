package edu.sandwichproductions.controller;

import edu.sandwichproductions.Game;
import edu.sandwichproductions.model.entity.Barbarian;
import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.model.map.Room;
import edu.sandwichproductions.view.Menu;
import edu.sandwichproductions.model.entity.Player;

public class GameController {
    private Map world;
    private final Menu menu;
    private Player player = new Barbarian("John");
    private final CombatController myCombat;
    private MovementController myMovement;
    private int selection = 0;
    private Game game;

    public GameController() {
        menu = new Menu();
        myCombat = new CombatController();
    }

    public void run(){
//        while (selection != 1) {
//            selection = menu.startMenu();
//            switch (selection) {
//                case 1 -> startGame();
//                case 2 -> menu.settingsMenu();
//            }
//        }
        startGame();
    }

    public void startGame() {
        game = new Game();
        world = new Map();
        myMovement = new MovementController(world);
//        playGame();
    }

    public void playGame() {
        while (player.isAlive()) {
            myMovement.move(player);

        }
    }

    public void attacking(Enemy enemy) {
        if (enemy != null) {
            myCombat.fight(player, enemy);
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public Map getWorld() {
        return this.world;
    }

    public Room[][] getRooms() {
        return this.world.getRooms();
    }

    public MovementController getMyMovement() {
        return this.myMovement;
    }

    public CombatController getMyCombat() { return this.myCombat; }
}