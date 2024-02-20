package com.neumont.model.item;

public class Sword extends DamageItem {
    public Sword(String name) {
        super(name, 10, 2, 8, 3);
    }

    @Override
    public String toString() {
        return "\nSword: " + super.toString();
    }
}
