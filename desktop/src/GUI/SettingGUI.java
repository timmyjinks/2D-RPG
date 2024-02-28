package GUI;

import edu.sandwichproductions.view.GameDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingGUI extends JDialog {

    public SettingGUI() {
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/setting-img.png");
        JButton difficulty = new JButton("Difficulty");
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        JButton back = new JButton("Go back silly");
        JButton setting = new JButton("Back");

        difficulty.setBounds(750, 400, 250, 100);
        setting.setBounds(750, 650, 250, 100);

        easy.setBounds(750,300,250,100);
        medium.setBounds(750,450,250,100);
        hard.setBounds(750,600,250,100);
        back.setBounds(750,750,250,100);

        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
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
        base.add(medium);
        base.add(hard);
        base.add(back);

        base.add(backgroundGUI);


        difficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                easy.setVisible(true);
                medium.setVisible(true);
                hard.setVisible(true);
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
                medium.setVisible(false);
                hard.setVisible(false);
                back.setVisible(false);
                setting.setVisible(true);
                difficulty.setVisible(true);
            }
        });

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
