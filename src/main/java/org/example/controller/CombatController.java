package org.example.controller;

import de.gurkenlabs.litiengine.entities.EntityInfo;
import org.example.model.Entity;
import org.example.view.Menu;

public class CombatController {
    Menu menu = new Menu();
    private int round = 1;
    private Entity attacker;
    private Entity defender;

    public void fight (Entity player, Entity enemy) {
        if (player == null || enemy == null)
        {
            return;
        }
        while (player.isAlive() && enemy.isAlive()) {
            if (round == 1) {
                getSpeed(player, enemy);
            } else {
                getPlayerTurn();
            }
            attacker.attack(defender);
            round++;
        }
    }

    private void getSpeed(Entity player, Entity enemy) {
        if (enemy.getSpeed() > player.getSpeed()) {
            attacker = enemy;
            defender = player;
        } else {
            attacker = player;
            defender = enemy;
        }
    }

    private void getPlayerTurn() {
        Entity temp = attacker;
        attacker = defender;
        defender = temp;
    }
}
