package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingGUI extends JDialog {

    public SettingGUI() {
        Base base = new Base();

        JButton difficulty = new JButton("Difficulty");
        JButton setting = new JButton("Setting");

        difficulty.setBounds(0, 0, 500, 500);
        setting.setBounds(500,500, 500, 500);

         base.add(difficulty);
         base.add(setting);


        difficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("difficulty");
            }
        });

        setting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base.dispose();
                new StartingMenuGUI();
            }
        });
    }
}
