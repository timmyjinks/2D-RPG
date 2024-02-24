package edu.sandwichproductions.model.map;

import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Skeleton;

public class BossRoom extends Room {
    public BossRoom() {
        this.hasPlayer = false;
        this.isEnemyRoom = true;
        this.isBossRoom = true;
        this.enemies = new Enemy[1];
        this.enemies[0] = new Skeleton("Ding Ding the Great");
        this.enemies[0].setHealth(9999);
        this.enemies[0].setPositionInRoom(24);
        this.enemies[0].setSpeed(500);
    }
}
