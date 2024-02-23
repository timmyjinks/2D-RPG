package GUI;

import edu.sandwichproductions.view.UserChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserClassGUI {
    public UserClassGUI(String prompt1){
        JPanel promptArea = new JPanel();
        JTextArea prompt = new JTextArea();
        prompt.setText(prompt1);


        promptArea.setLayout(new BorderLayout());



        prompt.setLineWrap(true); // Enable text wrapping
        prompt.setWrapStyleWord(true); // Wrap at word boundaries
        prompt.setEditable(false);

        JButton continueAhead = new JButton("Continue");




        continueAhead.setBounds(300, 850, 250, 100);
        continueAhead.setBackground(Color.GRAY);
        continueAhead.setFocusable(false);

        promptArea.setBackground(Color.YELLOW);

        promptArea.setBounds(675,200,400,200);

        Base base = new Base();

        base.add(continueAhead); // add the buttons to the forms



        promptArea.add(prompt);

        base.add(promptArea);

        continueAhead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                base.dispose();
                new MapGUI();
            }
        });
    }
}
