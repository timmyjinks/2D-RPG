<<<<<<<< HEAD:src/main/java/org/example/model/player/types/Barbarian.java
package org.example.model.player.types;

import org.example.model.Player;
========
package com.neumont.model.entity;
>>>>>>>> 45afbe1 (update to use libgdx):core/src/com/neumont/model/entity/Barbarian.java

public class Barbarian extends Player {
    public Barbarian(String name) {
        super(name, 65, 20,0);
    }

    @Override
    public String toString() {
        return "Barbarian:" + super.toString();
    }
}
