package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Entity;
import edu.sandwichproductions.model.entity.Player;
import edu.sandwichproductions.model.item.HealingItem;
import edu.sandwichproductions.util.ItemGenerator;
import edu.sandwichproductions.view.Menu;

public class CombatController {
    private final Menu menu = new Menu();
    private String fightLog = "";

    public void fight(Player attacker, Enemy defender) {
        fightLog = "";
        int round = 1;
        int damage = 0;
        int lineCount = 0;
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
                    damage = firstPlayer.attack(secondPlayer);
                } else {
                    secondPlayer.attack(firstPlayer);
                }
                if (round % 6 == 0){
                    attacker.addHealth(attacker.getRing().use());
                    System.out.println(attacker.getHealth());
                }
                if (lineCount != 14) {
                    fightLog += firstPlayer.getName() + " dealt " + damage + " to " + secondPlayer.getName() + "\n";
                    lineCount++;
                } else {
                    fightLog = fightLog.substring(fightLog.indexOf("\n") + 1);
                    lineCount--;
                }
                round++;
            }
            checkEnemyAlive(attacker, defender);
        }
    }

    private void checkEnemyAlive(Player attacker, Enemy defender){
        if (!defender.isAlive()){
            HealingItem tempHeal = attacker.getRing();
            if (tempHeal != null){
                attacker.addHealth(tempHeal.use());
            } else {
                InventoryController.checkEquippedItems(attacker);
            }
            if (defender.willDropItem()){
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

    public String getFightLog() {
        return fightLog;
    }
}
