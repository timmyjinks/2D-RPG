package edu.sandwichproductions.controller;

import edu.sandwichproductions.view.UserChoice;


public class PathTreeController {
    UserChoice get = new UserChoice();
    private int num;
    private String active;
    private int position;
    private boolean finish = false;


    public void mainTree(){
        if (position == 0){
            branch(get.Forest(),get.Mountain(),get.Town(),1,2,3); // Picking first path
        }
        else if(position == 1){
            branch(get.Forest1(),get.Forest2(),get.Forest3(),4,5,6); // Forest entry
        }
        else if(position == 2){
            branch(get.Mountain1(),get.Mountain2(),get.Mountain3(),7,8,9); // Mountain entry
        }
        else if(position == 3){
            branch(get.Town1(),get.Town2(),get.Town3(),10,11,12); // Town entry
        }
        getUserClass();
    }
    public void getUserClass(){
        if(position == 4){
            getUserClass(get.Druid());
        }
        else if(position == 5){
            getUserClass(get.Rogue());
        }
        else if(position == 6){
            getUserClass(get.Paladin());
        }
        switch(position){
            case 4:
                getUserClass(get.Druid());
                break;
            case 5:
            case 6:
                getUserClass(get.Rogue());
                break;
            case 7:
                getUserClass(get.Paladin());
                break;
            case 8:

                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
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