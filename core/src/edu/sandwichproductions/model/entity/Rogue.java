package edu.sandwichproductions.model.entity;

public class Rogue extends Player{
    public Rogue(String name){
        super(name,0,0,0);
    }
    @Override
    public String toString() {
        return "Rogue: " + super.toString();
    }
}
