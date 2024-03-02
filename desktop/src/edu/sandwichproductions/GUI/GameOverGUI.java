package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverGUI extends JDialog {
    public GameOverGUI() {
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/mountain-img.png");
        JFrame base = new JFrame();
        JButton tryAgain = new JButton();
        JButton quit = new JButton();


        quit.setIcon(new ImageIcon("assets/exit-Button.png"));
        tryAgain.setIcon(new ImageIcon("assets/again-button.png"));

        tryAgain.setBounds(750, 300, 250, 100);
        quit.setBounds(750,650,250, 100);

        tryAgain.setContentAreaFilled(false);
        quit.setContentAreaFilled(false);

        tryAgain.setFocusable(false);
        quit.setFocusable(false);

        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setExtendedState(JFrame.MAXIMIZED_BOTH);
        base.setVisible(true);

        base.add(tryAgain);
        base.add(quit);
        base.add(backgroundGUI);

        tryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StartingMenuGUI();
                base.dispose();
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base.dispose();
            }
        });
    }
}