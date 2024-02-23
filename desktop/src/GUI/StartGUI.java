package GUI;

import edu.sandwichproductions.controller.PathTreeController;
import edu.sandwichproductions.model.map.Map;
import edu.sandwichproductions.view.UserChoice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI {
    PathTreeController con = new PathTreeController();
    public StartGUI(){
        JPanel promptArea = new JPanel();
        JPanel path1Area = new JPanel();
        JPanel path2Area = new JPanel();
        JPanel path3Area = new JPanel();

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



        path1Area.setBackground(Color.CYAN);
        path2Area.setBackground(Color.magenta);
        path3Area.setBackground(Color.red);
        promptArea.setBackground(Color.YELLOW);




        path1Area.setBounds(225,500,400,200);
        path2Area.setBounds(675,500,400,200);
        path3Area.setBounds(1125,500,400,200);
        promptArea.setBounds(675,200,400,200);




        Base base = new Base();



        base.add(path1); // add the buttons to the forms
        base.add(path2);
        base.add(path3);



        promptArea.add(prompt);

        base.add(promptArea);
        base.add(path1Area);
        base.add(path2Area);
        base.add(path3Area);


        path1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.getNum(1);
                prompt.setText(con.getPrompt());
                con.getNum(0);
                if(con.finish()){
                    base.remove(path1);
                    base.remove(path3);
                    base.revalidate();
                    base.repaint();
                    path2.setText("Continue ahead");
                }
            }
        });
        path2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.getNum(2);
                prompt.setText(con.getPrompt());
                con.getNum(0);
                if(con.finish()){
                    base.remove(path1);
                    base.remove(path3);
                    base.revalidate();
                    base.repaint();
                    path2.setText("Continue ahead");
                    path2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            base.dispose();
                            new MapGUI();
                        }
                    });
                }
            }
        });
        path3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.getNum(3);
                prompt.setText(con.getPrompt());
                con.getNum(0);
                if(con.finish()){
                    base.remove(path1);
                    base.remove(path3);
                    base.revalidate();
                    base.repaint();
                    path2.setText("Continue ahead");
                }
            }
        });
    }
}
