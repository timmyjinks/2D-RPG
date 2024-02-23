package GUI;

import edu.sandwichproductions.view.UserChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartingMenuGUI extends Base {
    Image img;
    public StartingMenuGUI() {

        JButton start = new JButton("Start");
        JButton setting = new JButton("Setting");// Set buttons text
        JButton exit = new JButton("Exit");



        start.setBounds(750, 200, 250, 100);
        start.setBackground(Color.GRAY);
        start.setFocusable(false);


        setting.setBounds(750, 400, 250, 100); //this just add the location and size and change colors
        setting.setBackground(Color.GRAY);
        setting.setFocusable(false);


        exit.setBounds(750, 600, 250, 100);
        exit.setBackground(Color.GRAY);
        exit.setFocusable(false);

        Base base = new Base();

        base.add(start); // add the buttons to the forms
        base.add(setting);
        base.add(exit);

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
