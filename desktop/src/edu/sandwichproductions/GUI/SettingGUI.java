package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.event.*;

public class SettingGUI extends JDialog {

    public SettingGUI() {
        JFrame frame = new JFrame();
        JButton difficulty = new JButton("Difficulty");
        JButton setting = new JButton("Setting");

        difficulty.setBounds(0, 0, 500, 500);
        setting.setBounds(500,500, 500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.add(difficulty);
        frame.add(setting);

        difficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("difficulty");
            }
        });

        setting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartingMenuGUI();
            }
        });
    }
}
