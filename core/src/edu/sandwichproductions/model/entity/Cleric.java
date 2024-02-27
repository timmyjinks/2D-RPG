package edu.sandwichproductions.model.entity;

public class Cleric extends Player{
    public Cleric(String name){
        super(name,0,0,0);
    }
    @Override
    public String toString() {
        return "Cleric: " + super.toString();
    }
}
