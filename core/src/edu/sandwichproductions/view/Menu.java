package edu.sandwichproductions.view;

public class Menu {
    MyIO io = new MyIO();

    public int startMenu() {
        return io.intInput("-----------\n-- Start --\n-----------\n1) Start\n2) Settings\n3) Exit");
    }

    public int settingsMenu() {
        return io.intInput("1) Setting1\n2) Setting2\n3) Exit");
    }
  
    public int takeWeaponMenu() {
        return io.intInput("An Enemy dropped a weapon do you want to take it its weally powerful?\n" +
                "1) Take Weapon\2) Leave Weapon");
    }
}
