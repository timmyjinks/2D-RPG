package GUI;

import edu.sandwichproductions.controller.GameController;
import edu.sandwichproductions.controller.PathTreeController;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartGUI {
    PathTreeController con = new PathTreeController();
    public StartGUI(){
        JPanel promptArea = new JPanel();
        JTextArea prompt = new JTextArea();

        con.getNum(0);
        prompt.setText(con.getPrompt());

        promptArea.setLayout(new BorderLayout());

        prompt.setLineWrap(true); // Enable text wrapping
        prompt.setWrapStyleWord(true); // Wrap at word boundaries
        prompt.setEditable(false);

        JButton path1 = new JButton("Path1");
        JButton path2 = new JButton("Path2");
        JButton path3 = new JButton("Path3");

        path1.setBounds(300, 850, 250, 100);
        path1.setBackground(Color.GRAY);
        path1.setFocusable(false);

        path2.setBounds(750, 850, 250, 100); //this just add the location and size and change colors
        path2.setBackground(Color.GRAY);
        path2.setFocusable(false);

        path3.setBounds(1200, 850, 250, 100);
        path3.setBackground(Color.GRAY);
        path3.setFocusable(false);

        promptArea.setBackground(Color.YELLOW);

        promptArea.setBounds(675,200,400,200);

        JFrame base = new JFrame();

        base.add(path1); // add the buttons to the forms
        base.add(path2);
        base.add(path3);

        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setExtendedState(JFrame.MAXIMIZED_BOTH);
        base.setLayout(null);
        base.setVisible(true);


        promptArea.add(prompt);
        base.add(promptArea);
        final boolean[] work = {false};

        path1.addActionListener(e -> {
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
            }
        });
        path2.addActionListener(e -> {
            if(work[0]){
                base.dispose();
                new MapGUI();
            }
            else if(con.finish()){
                base.remove(path1);
                base.remove(path3);
                base.revalidate();
                base.repaint();
                path2.setText("Continue ahead");
                work[0] = true;
            }
            else{
                con.getNum(2);
                prompt.setText(con.getPrompt());
                con.getNum(0);
            }
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
                }
        });
    }
}
