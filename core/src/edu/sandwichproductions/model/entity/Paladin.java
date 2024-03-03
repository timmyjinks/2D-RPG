package edu.sandwichproductions.model.entity;

import edu.sandwichproductions.util.ItemSprite;

public class Paladin extends Player{
    public Paladin(String name) {
        super(name, entityRandom.nextInt(70, 90), entityRandom.nextInt(7,12), 13, ItemSprite.PALADIN);
    }
}
