package org.example.controller;

import org.example.model.mappy.Map;
import org.example.model.Player;

public class GameController {
    private Map world = new Map();
    private Player player;
    private MovementController myMovement = new MovementController(world);
    private CombatController myCombat = new CombatController();

    public void startHere(){

    }
}
