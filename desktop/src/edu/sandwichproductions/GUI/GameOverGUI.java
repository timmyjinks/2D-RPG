package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverGUI extends JDialog {
    public GameOverGUI() {
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/death.png");
        JFrame base = new JFrame();
        JButton tryAgain = new JButton("Try Again");
        JButton quit = new JButton("leave :(");

        quit.setIcon(new ImageIcon("assets/Exit_Button.png"));
        tryAgain.setBounds(750, 300, 250, 100);
        quit.setBounds(750,650,386, 165);
        tryAgain.setBackground(Color.DARK_GRAY);
        quit.setBackground(Color.darkGray);
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