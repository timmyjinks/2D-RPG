package edu.sandwichproductions.model.map;

import edu.sandwichproductions.model.entity.Enemy;
import edu.sandwichproductions.model.entity.Skeleton;

public class BossRoom extends Room {
    Enemy boss;

    public BossRoom() {
        this.hasPlayer = false;
        this.isEnemyRoom = true;
        this.isBossRoom = true;
        this.boss = new Skeleton("Ding Ding the Great");
        this.boss.setPositionInRoom(24);
        this.boss.setHealth(9999999);
        this.boss.setSpeed(500);
    }
}
