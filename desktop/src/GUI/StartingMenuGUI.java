package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingMenuGUI extends JFrame {
    public StartingMenuGUI() {
        // Create and configure the JFrame
        JFrame frame = new JFrame("Starting Menu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color to black
        frame.getContentPane().setBackground(Color.BLACK);

        // Create buttons
        JButton startButton = new JButton("Start");
        JButton settingsButton = new JButton("Settings");
        JButton saveButton = new JButton("Save");

        // Add ActionListeners to the buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Dispose the current menu frame
                new MapGUI();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Settings button clicked!");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Save button clicked!");
            }
        });

        // Create a JPanel and set its layout to BoxLayout with Y_AXIS alignment
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        // Add buttons to the panel
        panel.add(startButton);
        panel.add(settingsButton);
        panel.add(saveButton);

        // Center the panel within the frame
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
