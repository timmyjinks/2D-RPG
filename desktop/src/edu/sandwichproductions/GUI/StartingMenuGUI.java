package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingMenuGUI{
    public StartingMenuGUI() {
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/MenuCover.png");
        JButton start = new JButton();
        JButton setting = new JButton();// Set buttons text
        JButton exit = new JButton();

        start.setBounds(613, 200, 479, 166);
        start.setBackground(Color.GRAY);
        start.setFocusable(false);
        start.setIcon(new ImageIcon("assets/Start_Button.png"));


        setting.setBounds(520, 400, 664, 166); //this just add the location and size and change colors
        setting.setBackground(Color.GRAY);
        setting.setFocusable(false);
        setting.setIcon(new ImageIcon("assets/Settings_Button.png"));


        exit.setBounds(660, 600, 386, 165);
        exit.setBackground(Color.GRAY);
        exit.setFocusable(false);
        exit.setIcon(new ImageIcon("assets/Exit_Button.png"));

        JFrame base = new JFrame();
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setExtendedState(JFrame.MAXIMIZED_BOTH);
        base.setVisible(true);

        base.add(start); // add the buttons to the forms
        base.add(setting);
        base.add(exit);
        base.add(backgroundGUI);

        start.addActionListener(new ActionListener() { //this is the event handler for the buttons
            @Override
            public void actionPerformed(ActionEvent e) {
                base.dispose();
                new StartGUI();
            }
        });
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
