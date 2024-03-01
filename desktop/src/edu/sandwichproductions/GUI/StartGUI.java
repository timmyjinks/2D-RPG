package edu.sandwichproductions.GUI;

import edu.sandwichproductions.controller.PathTreeController;

import javax.swing.*;
import java.awt.*;

public class StartGUI {
    PathTreeController con = new PathTreeController();
    public StartGUI(){
        BackgroundGUI backgroundGUI = new BackgroundGUI("assets/path.png");

        JTextArea prompt = new JTextArea();

        con.getNum(0);
        prompt.setText(con.getPrompt());
        Font font = prompt.getFont();
        prompt.setFont(new Font(font.getFontName(),font.getStyle(),24));
        prompt.setBackground(Color.LIGHT_GRAY);
        prompt.setCaretColor(Color.LIGHT_GRAY);

        prompt.setLineWrap(true); // Enable text wrapping
        prompt.setWrapStyleWord(true); // Wrap at word boundaries
        prompt.setEditable(false);

        JButton path1 = new JButton();
        JButton path2 = new JButton();
        JButton path3 = new JButton();

        path1.setBounds(300, 850, 250, 100);
        path1.setIcon(new ImageIcon("assets/path-1.png"));
        path1.setContentAreaFilled(false);
        path1.setFocusable(false);

        path2.setBounds(750, 850, 250, 100);//this just add the location and size and change colors
        path2.setIcon(new ImageIcon("assets/path-2.png"));
        path2.setContentAreaFilled(false);
        path2.setFocusable(false);

        path3.setBounds(1200, 850, 250, 100);
        path3.setIcon(new ImageIcon("assets/path-3.png"));
        path3.setContentAreaFilled(false);
        path3.setFocusable(false);

        prompt.setBounds(650,300,400,300);

        JFrame base = new JFrame();

        base.add(path1); // add the buttons to the forms
        base.add(path2);
        base.add(path3);
        base.add(prompt);
        base.add(backgroundGUI);


        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setExtendedState(JFrame.MAXIMIZED_BOTH);
        base.setVisible(true);


        final boolean[] work = {false};

        path1.addActionListener(e -> {
            con.getNum(1);
            prompt.setText(con.getPrompt());
            con.getNum(0);
            if(con.finish()) {
                base.remove(path1);
                base.remove(path3);
                base.revalidate();
                base.repaint();
                path2.setText("Continue ahead");
                work[0] = true;
                path2.setIcon(new ImageIcon("assets/venture-button.png"));
            }
        });
        path2.addActionListener(e -> {
            if(work[0]){
                base.dispose();
                new MapGUI();
            }
            else{
                con.getNum(2);
                prompt.setText(con.getPrompt());
                con.getNum(0);
                if(con.finish()){
                    base.remove(path1);
                    base.remove(path3);
                    base.revalidate();
                    base.repaint();
                    path2.setText("Continue ahead");
                    work[0] = true;
                    path2.setIcon(new ImageIcon("assets/venture-button.png"));
            }}
        });
        path3.addActionListener(e -> {
                con.getNum(3);
                prompt.setText(con.getPrompt());
                con.getNum(0);
                if(con.finish()) {
                    base.remove(path1);
                    base.remove(path3);
                    base.revalidate();
                    base.repaint();
                    path2.setText("Continue ahead");
                    work[0] = true;
                    path2.setIcon(new ImageIcon("assets/venture-button.png"));
                }
        });
    }
}
