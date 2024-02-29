package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.event.*;

public class GameOverGUI extends JDialog {
    public GameOverGUI() {
        JFrame frame = new JFrame();
        JButton tryAgain = new JButton("Try Again");
        JButton quit = new JButton("Quit");

        tryAgain.setBounds(300, 150, 500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setLayout(null);

        frame.add(tryAgain);

        tryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StartingMenuGUI();
                frame.dispose();
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}