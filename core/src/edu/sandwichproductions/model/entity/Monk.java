package edu.sandwichproductions.model.entity;

public class Monk extends Player{
    public Monk(String name){
        super(name,0,0,0);
    }
    @Override
    public String toString() {
        return "Monk: " + super.toString();
    }
}
