package edu.sandwichproductions.controller;

import edu.sandwichproductions.model.entity.*;
import edu.sandwichproductions.view.UserChoice;


public class PathTreeController {
    UserChoice get = new UserChoice();
    private int num, position;
    private String active;
    private boolean finish = false;
    private static Player choice;
    public void mainTree(){
        switch (position) {
            case 0:
                branch(get.Forest(), get.Mountain(), get.Town(), 1, 2, 3); // Picking first path
                break;
            case 1:
                branch(get.Forest1(), get.Forest2(), get.Forest3(), 4, 5, 6); // Forest entry
                break;
            case 2:
                branch(get.Mountain1(), get.Mountain2(), get.Mountain3(), 7, 8, 9); // Mountain entry
                break;
            case 3:
                branch(get.Town1(), get.Town2(), get.Town3(), 10, 11, 12); // Town entry
                break;
            case 4:
                getUserClass(get.Druid(), get.Rogue(), get.Paladin(), new Druid("Name"), new Rogue("Dk"), new Paladin("Df")); // Forest options 1
                break;
            case 5:
                getUserClass(get.Druid(), get.Barbarian(), get.Druid(), new Druid("Name"), new Barbarian("Dk"), new Druid("Df")); // Forest options 2
                break;
            case 6:
                getUserClass(get.Cleric(), get.Druid(), get.Cleric(), new Cleric("Name"), new Druid("Dk"), new Cleric("Df")); // Forest options 3
                break;
            case 7:
                getUserClass(get.Monk(), get.Paladin(), get.Bard(), new Monk("Name"), new Paladin("Dk"), new Bard("Df")); // Mountain options 1
                break;
            case 8:
                getUserClass(get.Barbarian(), get.Wizard(), get.Bard(), new Barbarian("Name"), new Wizard("Dk"), new Bard("Df")); // Mountain options 2
                break;
            case 9:
                getUserClass(get.Cleric(), get.Wizard(), get.Monk(), new Cleric("Name"), new Wizard("Dk"), new Monk("Df")); // Mountain options 3
                break;
            case 10:
                getUserClass(get.Barbarian(), get.Rogue(), get.Rogue(), new Barbarian("Name"), new Rogue("Dk"), new Rogue("Df")); // Town options 1
                break;
            case 11:
                getUserClass(get.Monk(), get.Bard(), get.Rogue(), new Monk("Name"), new Bard("Dk"), new Rogue("Df")); // Town options 2
                break;
            case 12:
                getUserClass(get.Druid(), get.Wizard(), get.Paladin(), new Druid("Name"), new Wizard("Dk"), new Paladin("Df")); // Town options 3
                break;
            default:
                break;
        }
    }

    public void getUserClass(String class1, String class2, String class3, Player one, Player two, Player three){
        switch (num) {
            case 1:
                getUserClass(class1,one);
                break;
            case 2:
                getUserClass(class2,two);
                break;
            case 3:
                getUserClass(class3,three);
                break;
        }
    }
    public void branch(String prompt1, String prompt2, String prompt3,int pos1, int pos2, int pos3){
        if(num == 0){
            activePrompt(get.start());
        }
        switch (num){
            case 1:
                activePrompt(prompt1);
                position = pos1;
                break;
            case 2:
                activePrompt(prompt2);
                position = pos2;
                break;
            case 3:
                activePrompt(prompt3);
                position = pos3;
                break;
        }
    }


    public void getUserClass(String userClass, Player player){
        activePrompt(userClass);
        returnPlayer(player);
        finish = true;
    }
    public void returnPlayer(Player player){
        this.choice = player;
    }
    public void activePrompt(String prompt){
        this.active = prompt;
    }
    public Player playerChoice(){
        return choice;
    }
    public String getPrompt(){
        caseNum();
        mainTree();
        return active;
    }
    public int caseNum(){
        return num;
    }
    public void getNum(int num){
        this.num = num;
    }
    public boolean finish(){
        return finish;
    }
}