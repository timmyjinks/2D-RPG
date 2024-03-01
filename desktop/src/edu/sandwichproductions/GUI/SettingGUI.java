package edu.sandwichproductions.GUI;

import edu.sandwichproductions.util.Dice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SettingGUI extends JDialog {


    public SettingGUI() {
        Dice modifier = new Dice();
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/setting-img.png");


        JButton difficulty = new JButton();
        JButton easy = new JButton();
        JButton normal = new JButton();
        JButton medium = new JButton();
        JButton hard = new JButton();
        JButton Jshlatt = new JButton();
        JButton back = new JButton();
        JButton exit = new JButton();


        difficulty.setContentAreaFilled(false);
        easy.setContentAreaFilled(false);
        normal.setContentAreaFilled(false);
        medium.setContentAreaFilled(false);
        hard.setContentAreaFilled(false);
        Jshlatt.setContentAreaFilled(false);
        back.setContentAreaFilled(false);
        exit.setContentAreaFilled(false);

        difficulty.setIcon(new ImageIcon("assets/difficulty-button.png"));
        easy.setIcon(new ImageIcon("assets/easy-button.png"));
        normal.setIcon(new ImageIcon("assets/normal-button.png"));
        medium.setIcon(new ImageIcon("assets/medium-button.png"));
        hard.setIcon(new ImageIcon("assets/hard-button.png"));
        Jshlatt.setIcon(new ImageIcon("assets/Jshlatt-button.png"));
        back.setIcon(new ImageIcon("assets/Back-button.png"));
        exit.setIcon(new ImageIcon("assets/Back-button.png"));



        difficulty.setBounds(700, 400, 350, 150);
        exit.setBounds(700, 600, 350, 150);


        easy.setBounds(175,100,350,150);
        normal.setBounds(175,325,350,150);

        medium.setBounds(1200,100,350,150);
        hard.setBounds(1200,325,350,150);

        Jshlatt.setBounds(700,400,350,150);

        back.setBounds(700,800,350,150);


        easy.setVisible(false);
        normal.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        Jshlatt.setVisible(false);
        back.setVisible(false);


        difficulty.setFocusable(false);
        exit.setFocusable(false);


        JFrame base = new JFrame();
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setExtendedState(JFrame.MAXIMIZED_BOTH);
        base.setVisible(true);


        base.add(difficulty);
        base.add(exit);
        base.add(easy);
        base.add(normal);
        base.add(medium);
        base.add(hard);
        base.add(Jshlatt);
        base.add(back);
        base.add(backgroundGUI);


        difficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                easy.setVisible(true);
                normal.setVisible(true);
                medium.setVisible(true);
                hard.setVisible(true);
                Jshlatt.setVisible(true);
                back.setVisible(true);
                exit.setVisible(false);
                difficulty.setVisible(false);
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base.dispose();
                new StartingMenuGUI();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                easy.setVisible(false);
                normal.setVisible(false);
                medium.setVisible(false);
                hard.setVisible(false);
                Jshlatt.setVisible(false);
                back.setVisible(false);
                exit.setVisible(true);
                difficulty.setVisible(true);
            }
        });
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifier.setMode(.5);
            }
        });
        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifier.setMode(1);
            }
        });
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifier.setMode(1.5);
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifier.setMode(2);
            }
        });
        Jshlatt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifier.setMode(10); // :( no survival :(
            }
        });
    }
}
