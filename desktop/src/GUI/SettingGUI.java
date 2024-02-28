package GUI;


import edu.sandwichproductions.util.Dice;
import edu.sandwichproductions.view.GameDisplay;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SettingGUI extends JDialog {


    public SettingGUI() {
        Dice modifier = new Dice();
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/setting-img.png");


        JButton difficulty = new JButton("Difficulty");
        JButton easy = new JButton("Easy");
        JButton normal = new JButton("normal");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        JButton Jshlatt = new JButton("Shlagg :(");
        JButton back = new JButton("Go back silly");
        JButton setting = new JButton("Back");


        difficulty.setBounds(750, 400, 250, 100);
        setting.setBounds(750, 650, 250, 100);




        easy.setBounds(750,75,250,100);
        normal.setBounds(750,200,250,100);
        medium.setBounds(750,325,250,100);
        hard.setBounds(750,459,250,100);
        Jshlatt.setBounds(750,575,250,100);
        back.setBounds(750,800,250,100);




        easy.setVisible(false);
        normal.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        Jshlatt.setVisible(false);
        back.setVisible(false);


        difficulty.setFocusable(false);
        setting.setFocusable(false);


        JFrame base = new JFrame();
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setExtendedState(JFrame.MAXIMIZED_BOTH);
        base.setVisible(true);
        base.add(difficulty);
        base.add(setting);
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
                setting.setVisible(false);
                difficulty.setVisible(false);
            }
        });
        setting.addActionListener(new ActionListener() {
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
                setting.setVisible(true);
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
