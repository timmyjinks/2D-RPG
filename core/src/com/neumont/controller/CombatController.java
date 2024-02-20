package com.neumont.controller;

import com.neumont.model.entity.Entity;
import com.neumont.view.Menu;

public class CombatController {
    Menu menu = new Menu();
    int round = 1;
    public void fight (Entity attacker, Entity defender) {
        if (attacker == null || defender == null)
        {
            return;
        }
        while (attacker.isAlive() || defender.isAlive()) {
            if (round == 1) {
                attacker = getSpeed(attacker, defender);
            } else {
                attacker = getPlayerTurn(defender);
            }
            attacker.attack(defender);
        }
    }

    private Entity getSpeed(Entity attacker, Entity defender) {
        if (defender.getSpeed() > attacker.getSpeed()) {
            return defender;
        } else {
            return attacker;
        }
    }

    private Entity getPlayerTurn(Entity defender) {
        return defender;
    }
}
