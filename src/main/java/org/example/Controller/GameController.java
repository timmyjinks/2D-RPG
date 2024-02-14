package org.example.Controller;

import org.example.Model.MapStuff.Map;
import org.example.Model.Player;

public class GameController {
    private Map world = new Map();
    private MovementController myMovement = new MovementController(world);
    private CombatController myCombat = new CombatController();
    public void startHere(){
//        myMovement.move(myPlayer);
    }
}
