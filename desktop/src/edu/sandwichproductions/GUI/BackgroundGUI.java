package edu.sandwichproductions.GUI;

import javax.swing.*;
import java.awt.*;

public class BackgroundGUI extends JPanel {
    Image pic;
    public BackgroundGUI(String fileName){
        ImageIcon obj = new ImageIcon(fileName);
        pic = obj.getImage();
        setPreferredSize(new Dimension(pic.getWidth(null), pic.getHeight(null)));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(pic,0,0,1710,1030,null);
    }
}
