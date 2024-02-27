package edu.sandwichproductions.model.entity;

public class Bard extends Player{
    public Bard(String name){
        super(name,0,0,0);
    }

    @Override
    public String toString() {
        return "Bard: " + super.toString();
    }
}