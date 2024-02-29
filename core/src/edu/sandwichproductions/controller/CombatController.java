package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Entity;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.util.ItemGenerator;
import edu.sandwichproductions.view.Menu;

public class CombatController {
    Menu menu = new Menu();

    public void fight(Player attacker, Enemy defender) {
        int round = 1;
        Entity firstPlayer = null;
        Entity secondPlayer = null;
        if (attacker == null || defender == null) {
            return;
        }
        while (attacker.isAlive() && defender.isAlive()) {
            if (round == 1) {
                int turnOrder = checkSpeed(attacker, defender);
                secondPlayer = switch (turnOrder) {
                    case 1 -> {
                        firstPlayer = defender;
                        yield attacker;
                    }
                    case 2 -> {
                        firstPlayer = attacker;
                        yield defender;
                    }
                    default -> secondPlayer;
                };
            }
            if (firstPlayer != null) {
                if (round % 2 == 1) {
                    firstPlayer.attack(secondPlayer);
                } else {
                    secondPlayer.attack(firstPlayer);
                }
                round++;
            }
            if (!defender.isAlive() && defender.willDropItem()){
                attacker.addItem(ItemGenerator.generateItem());
            }
        }
    }

    private int checkSpeed(Entity attacker, Entity defender) {
        if (defender.getSpeed() > attacker.getSpeed()) {
            return 1;
        } else {
            return 2;
        }
    }
}
