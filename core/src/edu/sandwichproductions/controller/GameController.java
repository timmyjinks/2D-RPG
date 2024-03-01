package edu.sandwichproductions.controller;

import edu.sandwichproductions.Game;
import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.model.map.Room;
import edu.sandwichproductions.view.Menu;

public class GameController {
    private Map world;
    private PathTreeController con;
    private Player player;
    private CombatController myCombat;
    private MovementController myMovement;

    public GameController() {
        myCombat = new CombatController();
    }

    public void run(){
        startGame();
    }

    public void startGame() {
        world = new Map();
        myMovement = new MovementController(world);
    }

    public Player createPlayer() {
        con = new PathTreeController();
        return player = con.playerChoice();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Map getWorld() {
        return this.world;
    }

    public MovementController getMyMovement() {
        return this.myMovement;
    }

    public CombatController getMyCombat() { return this.myCombat; }
}