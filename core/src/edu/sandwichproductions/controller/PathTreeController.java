package edu.sandwichproductions.controller;

import edu.sandwichproductions.view.UserChoice;

import java.nio.file.attribute.PosixFileAttributes;


public class PathTreeController {
    UserChoice get = new UserChoice();
    private int num, position;
    private String active;
    private boolean finish = false;
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
                getUserClass(get.Druid(), get.Rogue(), get.Paladin()); // Forest options 1
                break;
            case 5:
                getUserClass(get.Druid(), get.Barbarian(), get.Druid()); // Forest options 2
                break;
            case 6:
                getUserClass(get.Cleric(), get.Druid(), get.Cleric()); // Forest options 3
                break;
            case 7:
                getUserClass(get.Monk(), get.Paladin(), get.Bard()); // Mountain options 1
                break;
            case 8:
                getUserClass(get.Barbarian(), get.Wizard(), get.Bard()); // Mountain options 2
                break;
            case 9:
                getUserClass(get.Cleric(), get.Wizard(), get.Monk()); // Mountain options 3
                break;
            case 10:
                getUserClass(get.Barbarian(), get.Rogue(), get.Rogue()); // Town options 1
                break;
            case 11:
                getUserClass(get.Monk(), get.Bard(), get.Rogue()); // Town options 2
                break;
            case 12:
                getUserClass(get.Druid(), get.Wizard(), get.Paladin()); // Town options 3
                break;
            default:
                break;
        }
    }


    public void getUserClass(String class1,String class2,String class3){
        switch(num){
            case 1:
                getUserClass(class1);
                break;
            case 2:
                getUserClass(class2);
                break;
            case 3:
                getUserClass(class3);
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


    public void getUserClass(String userClass){
        activePrompt(userClass);
        finish = true;
    }
    public void activePrompt(String prompt){
        this.active = prompt;
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