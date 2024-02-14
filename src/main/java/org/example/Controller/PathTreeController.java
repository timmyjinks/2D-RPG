package org.example.Controller;
import org.example.View.UserChoice;


import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.nio.file.Path;
import java.sql.SQLOutput;


public class PathTreeController {
    UserChoice get = new UserChoice();
    public void startOfPath() throws InterruptedException, IOException {
        boolean vool = true;
        while (vool) {
            String user = get.start();
            switch (user){
                case "1":
                    String userA = get.Forest();
                    switch (userA){
                        case "1":
                            userA = get.Forest1();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                        case "2":
                            userA = get.Forest2();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                        case "3":
                            userA = get.Forest3();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                    }
                    break;
                case "2":
                    String userB = get.Mountain();
                    switch (userB){
                        case "1":
                            userA = get.Mountain1();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                        case "2":
                            userA = get.Mountain2();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                        case "3":
                            userA = get.Mountain3();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                    }
                    break;
                case "3":
                    String userC = get.Town();
                    switch (userC){
                        case "1":
                            userA = get.Town1();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }
                        case "2":
                            userA = get.Town2();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }


                        case "3":
                            userA = get.Town3();
                            switch (userA){
                                case "1":
                                    ahead();
                                    break;
                                case "2":
                                    ahead();
                                    break;
                                case "3":
                                    ahead();
                                    break;
                            }


                    }
                    break;
            }
        }
    }
    public void ahead() throws InterruptedException, IOException {
        String text = "Press e to continue";
        boolean continueLoop = true;
        do {
            System.out.print(text);
            Thread.sleep(1000);
            for (int i = 0; i < text.length(); i++) {
                System.out.print("\b");
            }
            Thread.sleep(400);
            if (System.in.available() > 0) {
                char input = (char) System.in.read();
                if (input == 'e') {
                    continueLoop = false;
                }
            }
        } while (continueLoop);
    }
    public boolean continueUser(){
        boolean vool = true;
        if(get.pressAhead().equals("e")){
            vool = false;
        }
        return vool;
    }
}
