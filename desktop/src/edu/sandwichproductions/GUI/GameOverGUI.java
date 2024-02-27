package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.event.*;

public class GameOverGUI extends JDialog {
    public GameOverGUI() {
        Base base = new Base();

        JButton tryAgain = new JButton("Try Again");
        JButton quit = new JButton("Quit");

        tryAgain.setBounds(300, 150, 500, 500);

        base.add(tryAgain);


        tryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base.dispose();
                new StartingMenuGUI();
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base.dispose();
            }
        });
    }
}