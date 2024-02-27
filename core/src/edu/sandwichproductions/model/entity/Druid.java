package edu.sandwichproductions.model.entity;

public class Druid extends Player{
    public Druid(String name){
        super(name,0,0,0);
    }
    @Override
    public String toString() {
        return "Druid: " + super.toString();
    }
}
