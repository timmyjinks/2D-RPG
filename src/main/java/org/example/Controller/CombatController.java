package org.example.Controller;

import org.example.Model.Creature;
import org.example.View.Menu;

public class CombatController {
    Menu menu = new Menu();
     int round = 1;
    public void fight (Creature attacker, Creature defender) {
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

    private Creature getSpeed(Creature attacker, Creature defender) {
        if (defender.getSpeed() > attacker.getSpeed()) {
            return defender;
        } else {
            return attacker;
        }
    }

    private Creature getPlayerTurn(Creature defender) {
        return defender;
    }
}
