package org.example.controller;

import org.example.model.Barbarian;
import org.example.model.Enemy;
import org.example.model.Goblin;
import org.example.model.MapStuff.Map;
import org.example.model.Player;
import org.example.model.itemStuff.Sword;

public class GameController {
    private Map world = new Map();
    private Player player;
    private MovementController myMovement = new MovementController(world);
    private CombatController myCombat = new CombatController();

    public void startHere(){
        player = new Barbarian("name");
        player.setHealth(65);
        player.setSpeed(20);
        player.setWeapon(new Sword("name"));
        Enemy enemy = new Goblin("name");

        myCombat.fight(player, enemy);

        System.out.println(player.toString() + "\n" + enemy.toString());
    }
}
